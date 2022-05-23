package com.sp.interceptors;

import java.util.logging.Logger;
import com.sp.service.JwtService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    JwtService jwtService;

    public static Integer userId = null;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger.getGlobal().warning(request.getRequestURL().toString());
        
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String authorization = request.getHeader("Authorization");
        System.out.println("authorizaton"+authorization);
        if (authorization != null && !authorization.equals("undefined")) {
            String token = authorization.toString();
            Integer userId = Integer.parseInt(this.jwtService.getUsernameFromToken(token));
            response.setHeader("X-Auth-User", String.valueOf(userId));
            AuthInterceptor.userId = userId;
            return this.jwtService.validateToken(token);
        }
        response.sendError(403, "Not authenticated");
        Logger.getGlobal().warning("Token " + authorization);
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception) throws Exception {
    }

}
