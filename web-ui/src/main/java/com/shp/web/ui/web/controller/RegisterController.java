package com.shp.web.ui.web.controller;

import com.shp.commons.dto.BaseResult;
import com.shp.domain.User;
import com.shp.web.ui.service.UserStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.shp.commons.constant.ConstantUtils.STATUS_SUCCESS;

/**
 * @Description:
 * @Author: sunhp
 * @Date:
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private UserStuService userStuService;

    @RequestMapping(value = "getForm",method = RequestMethod.GET)
    public String getForm(){
        return "register";
    }

    //注册用户
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, RedirectAttributes attributes, Model model){
        BaseResult save = userStuService.save(user);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            //attributes.addFlashAttribute("save",save);
            return "login";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "register";
        }
    }
}
