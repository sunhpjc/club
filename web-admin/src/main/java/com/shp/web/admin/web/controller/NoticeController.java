package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.Notice;
import com.shp.web.admin.service.NoticeService;
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

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/20 9:03
 */
@Controller
@RequestMapping(value = "notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @ModelAttribute
    public Notice getNotice(Long id){
        Notice notice = null;
        if(id!=null){
            notice=noticeService.getById(id);
        }
        else{
            notice = new Notice();
        }
        return notice;
    }

    //用户列表
    @RequestMapping(value = "notice_list",method = RequestMethod.GET)
    public String noticeList(){
        return "user_notice_list";
    }

    //获取添加--修改用户表单
    @RequestMapping(value = "notice_form",method = RequestMethod.GET)
    public String adminForm(Model model){
        return "user_notice_form";
    }
    //添加用户
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Notice notice, RedirectAttributes attributes, Model model,HttpServletRequest request){
        AdminUser user = (AdminUser) request.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        notice.setClubId(user.getClubId());
        BaseResult save = noticeService.save(notice);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/notice/notice_list";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "user_notice_form";
        }
    }

    //用户详情
    @RequestMapping(value = "notice_detail")
    public String detail(){
        return "user_notice_detail";
    }

    //删除用户
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            noticeService.deleteMulti(ids);
            baseResult=BaseResult.success("删除信息成功");
        }
        else {
            baseResult=BaseResult.fail("删除信息失败");
        }
        return baseResult;
    }
    //修改用户信息
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<Notice> pageInfo(HttpServletRequest request, Notice notice){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        String strClubId = request.getParameter("clubId");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);
        notice.setClubId(Long.parseLong(strClubId));

        //封装dataTable数据
        PageInfo<Notice> pageInfo = noticeService.dataTableSearch(start,length,draw,notice);
        return pageInfo;
    }
}
