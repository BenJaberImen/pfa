package tn.essat.projet1.securite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutohJwt implements AuthenticationEntryPoint {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AutohJwt.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        LOGGER.error("Unauthorized error: {}",e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error: UNAUTHORIZED");
    }

}
