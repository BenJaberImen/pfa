package tn.essat.projet1.securite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.essat.projet1.Response.JwtResponse;
import tn.essat.projet1.securite.service.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthToken extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserServiceImpl userService;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AuthToken.class);
    private JwtResponse jwt;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
                String jwt = parseJwt(request);

                if (jwt != null && jwtUtil.validateJwtToken(jwt)) {
                    String login = jwtUtil.getUserNameFromJwtToken(jwt);
                    UserDetails userDetails = userService.loadUserByUsername(login);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (Exception e) {
                LOGGER.error("Cannot set user authentication: {} ", e);
            }
            filterChain.doFilter(request,response);
        }
        private String parseJwt (HttpServletRequest request){
            String headerAuth = request.getHeader("Authorization");
            if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
                return headerAuth.substring(7, headerAuth.length());
            }
            return null;
        }




}
