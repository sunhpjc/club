package com.shp.web.admin.web.controller;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.GroupApplications;
import com.shp.web.admin.service.GroupApplicationService;
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

@Controller
@RequestMapping(value = "group")
public class GroupApplicationController {
    @Autowired
    private GroupApplicationService groupApplicationService;
    @ModelAttribute
    public GroupApplications getById(Long id){
        GroupApplications groupApplications = null;
        if(id!=null){
            groupApplications=groupApplicationService.getById(id);
        }
        else{
            groupApplications = new GroupApplications();
        }
        return groupApplications;
    }
    //列表
    @RequestMapping(value = "group_application_list",method = RequestMethod.GET)
    public String List(){
        return "group_application_list";
    }
    //详情
    @RequestMapping(value = "group_application_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "group_application_detail";
    }
    //通过申请
    @ResponseBody
    @RequestMapping(value = "applicationPass",method = RequestMethod.POST)
    public BaseResult applicationPass(String id,Model model){
        BaseResult baseResult = null;
        groupApplicationService.applicationPass(id);
        baseResult = BaseResult.success("操作成功");
        return baseResult;
    }
    //拒绝申请
    @ResponseBody
    @RequestMapping(value = "applicationRefuse",method = RequestMethod.POST)
    public BaseResult applicationRefuse(String id,Model model){
        BaseResult baseResult = null;
        groupApplicationService.applicationRefuse(id);
        baseResult = BaseResult.success("操作成功");
        return baseResult;
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<GroupApplications> pageInfo(HttpServletRequest request, GroupApplications groupApplications){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<GroupApplications> pageInfo = groupApplicationService.dataTableSearch(start,length,draw,groupApplications);
        return pageInfo;
    }
    //POST方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageInfo<GroupApplications> pageInfo1(HttpServletRequest request,GroupApplications groupApplications){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<GroupApplications> pageInfo = groupApplicationService.dataTableSearch(draw,start,length,groupApplications);
        return pageInfo;
    }
}
