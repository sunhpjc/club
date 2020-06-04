package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.Club;
import com.shp.domain.User;
import com.shp.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.shp.commons.constant.ConstantUtils.STATUS_SUCCESS;

/**
 * @Description: 社团管理员管理用户
 * @Author: sunhp
 * @Date: 2020/4/3 19:35
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @ModelAttribute
    public User getUser(Long id){
        User user;
        if(id!=null){
            user=userService.getUserById(id);
        }
        else{
            user = new User();
        }
        return user;
    }
    //列表
    @RequestMapping(value = "user_list",method = RequestMethod.GET)
    public String userList(){
        return "user_list";
    }

    //获取添加--修改用户表单
    @RequestMapping(value = "user_form",method = RequestMethod.GET)
    public String studentForm(){
        return "user_form";
    }
    @RequestMapping(value = "user_form_edit",method = RequestMethod.GET)
    public String userForm(){
        return "user_form_edit";
    }
    //添加
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, RedirectAttributes attributes, Model model,HttpServletRequest httpServletRequest){
        //获取用户session
        AdminUser adminUser=(AdminUser) httpServletRequest.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        Long clubId = adminUser.getClubId();
        User userGetId = userService.getUserByEntity(user);
        Long userId = userGetId.getUserId();

        BaseResult save = userService.save(user,clubId,userId);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/user/user_list";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "user_form";
        }
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            userService.deleteMulti(ids);
            baseResult=BaseResult.success("删除用户信息成功");
        }
        else {
            baseResult=BaseResult.fail("删除用户信息失败");
        }
        return baseResult;
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<User> pageInfo(HttpServletRequest request, Club club,User user){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        String strClubId = request.getParameter("clubId");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);
        long clubId = Long.parseLong(strClubId);
        club.setClubId(clubId);
        //封装dataTable数据
        PageInfo<User> pageInfo = userService.dataTableSearch(start,length,draw,club,user);
        return pageInfo;
    }
}
