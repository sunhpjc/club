package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.ClubApplications;
import com.shp.web.admin.service.ClubApplicationService;
import com.shp.web.admin.service.UserClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/4/11 14:08
 */
@Controller
@RequestMapping(value = "club_application")
public class ClubApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(ClubApplicationController.class);
    @Autowired
    private ClubApplicationService clubApplicationService;
    @Autowired
    private UserClubService userClubService;

    @ModelAttribute
    public ClubApplications getById(Long id){
        ClubApplications clubApplications = null;
        if(id!=null){
            clubApplications=clubApplicationService.getById(id);
        }
        else{
            clubApplications = new ClubApplications();
        }
        return clubApplications;
    }
    //列表
    @RequestMapping(value = "club_application_list",method = RequestMethod.GET)
    public String List(){
        return "user_club_application_list";
    }
    //详情
    @RequestMapping(value = "club_application_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "user_club_application_detail";
    }
    //通过申请
    @ResponseBody
    @RequestMapping(value = "applicationPass",method = RequestMethod.POST)
    public BaseResult application(Long id,Model model){
        BaseResult baseResult = null;
        if(id==null){
            baseResult=BaseResult.fail("申请id为null");
            logger.error("申请id为null");
        }
        ClubApplications clubApplications = clubApplicationService.getById(id);
        if(clubApplications.getClubApplicationType()==1){
            userClubService.save(clubApplications.getClubId(),clubApplications.getUserId());
            clubApplicationService.applicationPassJoin(clubApplications.getClubId());
            baseResult = BaseResult.success("用户加入社团成功");
        }
        if(clubApplications.getClubApplicationType()==0){
            userClubService.delete(clubApplications.getClubId(),clubApplications.getUserId());
            clubApplicationService.applicationPassJoin(clubApplications.getClubId());
            baseResult = BaseResult.success("用户退出社团成功");

        }
        return baseResult;
    }
    //拒绝申请
    @ResponseBody
    @RequestMapping(value = "applicationRefuse",method = RequestMethod.POST)
    public BaseResult applicationRefuse(Long id,Model model){
        BaseResult baseResult = null;
        clubApplicationService.applicationRefuse(id);
        baseResult = BaseResult.success("操作成功");
        return baseResult;
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<ClubApplications> pageInfo(HttpServletRequest request, ClubApplications clubApplications){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        AdminUser adminUser = (AdminUser)request.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        Long clubId = adminUser.getClubId();

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);
        clubApplications.setClubId(clubId);

        //封装dataTable数据
        PageInfo<ClubApplications> pageInfo = clubApplicationService.dataTableSearch(start,length,draw,clubApplications);
        return pageInfo;
    }
}
