package com.shp.web.ui.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.domain.User;
import com.shp.web.ui.service.UserStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserStuService userStuService;
    //进入登录页
    @RequestMapping(value={"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true)String email, @RequestParam(required = true)String password, HttpServletRequest req, Model model){
        User user = userStuService.login(email,password);
        if(user==null){
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
        else if(user.getUserStatus()==1){
            //将登录信息放入会话
            req.getSession().setAttribute(ConstantUtils.USER_SESSION,user);
            req.getSession().setMaxInactiveInterval(1800);
            return "redirect:/main";
        }
        else {
            return "login";
        }
    }
    //注销
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest req){
        //清除session
        req.getSession().invalidate();
        return "login";
    }
}
