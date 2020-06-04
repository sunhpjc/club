package com.shp.web.ui.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.domain.User;
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
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.USER_SESSION);
        return "main";
    }
}
