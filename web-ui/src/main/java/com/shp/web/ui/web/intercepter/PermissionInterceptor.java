package com.shp.web.ui.web.intercepter;

import com.shp.commons.constant.ConstantUtils;
import com.shp.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //以end结尾的表示在请求登录页
        //modelAndView!=null&&modelAndView.getViewName()!=null 在使用json传输数据的时候添加，因为获取的不再是页面，而是json字符串
        if(modelAndView!=null&&modelAndView.getViewName()!=null&&modelAndView.getViewName().endsWith("login")){
            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
            if(user!=null&&user.getUserStatus()==1){
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
