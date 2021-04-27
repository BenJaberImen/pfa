package tn.essat.projet1.securite;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import tn.essat.projet1.securite.service.UserDetailsImpl;

import java.util.Date;


@Component
public class JwtUtil {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AutohJwt.class);
    @Value("${tn.jihen.jwtSecret}")
    private String jwtSecret;
    @Value("86400000")
    private int jwtExpirationMs;

public String token(Authentication authentication){
    UserDetailsImpl userDetails= (UserDetailsImpl) authentication.getPrincipal() ;
    return Jwts.builder()
            .setSubject((userDetails.getUsername()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();




}
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT token signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token : {}", e.getMessage());
        } catch ( ExpiredJwtException e) {
            LOGGER.error(" JWT token expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims empty: {}", e.getMessage());
        }
        return false;
    }


}
