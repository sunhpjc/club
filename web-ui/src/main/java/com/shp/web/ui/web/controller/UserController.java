package com.shp.web.ui.web.controller;

import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.User;
import com.shp.web.ui.service.UserStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.shp.commons.constant.ConstantUtils.STATUS_SUCCESS;


@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserStuService userStuService;
    @ModelAttribute
    public User getUser(Long id){
        User user = null;
        if(id!=null){
            user= userStuService.getUserById(id);
        }
        else{
            user = new User();
        }
        return user;
    }

    /**
     * 获取用户详情
     * @return
     */
    @RequestMapping(value = "userDetail",method = RequestMethod.GET)
    public String userDetail(){
        return "user_detail";
    }

    /**
     * 修改用户信息
     * @param user
     * @param attributes
     * @param model
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String update(User user, RedirectAttributes attributes, Model model){
        BaseResult save = userStuService.update(user);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/main";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "user_detail";
        }
    }
}
