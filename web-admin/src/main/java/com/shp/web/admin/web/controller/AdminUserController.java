package com.shp.web.admin.web.controller;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.web.admin.service.AdminUserService;
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

import java.util.List;

import static com.shp.commons.constant.ConstantUtils.STATUS_SUCCESS;

@Controller
@RequestMapping(value = "admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @ModelAttribute
    public AdminUser getUser(Long id){
        AdminUser adminUser = null;
        if(id!=null){
            adminUser=adminUserService.getUserById(id);
        }
        else{
            adminUser = new AdminUser();
        }
        return adminUser;
    }

    //用户列表
    @RequestMapping(value = "admin_list",method = RequestMethod.GET)
    public String userList(){
        return "admin_list";
    }
    //用户详情
    @RequestMapping(value = "admin_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "admin_detail";
    }
    //获取添加--修改用户表单
    @RequestMapping(value = "admin_form",method = RequestMethod.GET)
    public String adminForm(Model model){
        List<AdminUser> userList = adminUserService.searchClub();
        model.addAttribute("userList",userList);
        return "admin_form";
    }
    //添加用户
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(AdminUser adminUser, RedirectAttributes attributes, Model model){
        BaseResult save = adminUserService.save(adminUser);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/admin/admin_list";
        }
        //保存失败
        else {
            List<AdminUser> userList = adminUserService.searchClub();
            //验证失败之后form表单不再有社团信息，所以再发送一次
            model.addAttribute("userList",userList);
            model.addAttribute("save",save);
            return "admin_form";
        }
    }
    //删除用户
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            adminUserService.deleteMulti(ids);
            baseResult=BaseResult.success("删除用户信息成功");
        }
        else {
            baseResult=BaseResult.fail("删除用户信息失败");
        }
        return baseResult;
    }
    //修改用户信息
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<AdminUser> pageInfo(HttpServletRequest request,AdminUser user){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<AdminUser> pageInfo = adminUserService.dataTableSearch(start,length,draw,user);
        return pageInfo;
    }
    //POST方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageInfo<AdminUser> pageInfo1(HttpServletRequest request,AdminUser user){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<AdminUser> pageInfo = adminUserService.dataTableSearch(draw,start,length,user);
        return pageInfo;
    }
}
