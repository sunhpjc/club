package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.domain.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping(value = "main",method = RequestMethod.GET)
    //user session存在就自动登录
    public String main(HttpServletRequest httpServletRequest){
        //做权限（待定）
        AdminUser user = (AdminUser) httpServletRequest.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        return "main";
    }
    @RequestMapping(value = "user_main",method = RequestMethod.GET)
    //user session存在就自动登录
    public String userMain(){
        return "user_main";
    }
}
