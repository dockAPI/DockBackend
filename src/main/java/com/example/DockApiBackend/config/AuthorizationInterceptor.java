package com.example.DockApiBackend.config;// AuthorizationInterceptor.java

import com.example.DockApiBackend.Service.GitHubApiService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private GitHubApiService gitHubApiService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && gitHubApiService.isValidGitHubToken(token)) {
            return true; // Proceed with the request
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return false; // Stop processing the request
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // This method can be used for post-processing if needed
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // This method can be used for cleaning up resources if needed
    }
}
