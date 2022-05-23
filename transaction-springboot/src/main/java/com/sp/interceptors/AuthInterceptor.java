package com.sp.interceptors;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {

    public static Integer userId = null;

    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger.getGlobal().warning(request.getRequestURL().toString());
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String xAuthId = request.getHeader("X-Auth-User");
        if (xAuthId != null && xAuthId.equals("undefined") == false) {
            Integer user_id = Integer.parseInt(xAuthId);
            AuthInterceptor.userId = user_id;
            return true;
        }
        response.sendError(403, "Not authenticated");
        Logger.getGlobal().warning("Token " + xAuthId);
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
