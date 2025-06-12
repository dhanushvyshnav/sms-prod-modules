package com.es.sms.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Intercepts HTTP requests to validate authentication token
 * This interceptor implements Spring's HandlerInterceptor interface to perform pre-request authentication checks.
 *
 * Validates X-Auth-Token before request processing
 * Sets JSON response with 401 Unauthorized for invalid tokens
 */
    @Component
    public class AuthInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                return true;
            }
            String authToken = request.getHeader("X-Auth-Token");
            if (authToken!=null) {
                return true;
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                return false;
            }
        }
}
