package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.*;
import com.shp.web.admin.dao.PlaceDao;
import com.shp.web.admin.service.ActivityService;
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
@RequestMapping(value = "activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private PlaceDao placeDao;

    @ModelAttribute
    public Activity getActivity(Long id){
        Activity activity = null;
        if(id!=null){
            activity=activityService.getById(id);
            String time=activity.getTime();
            activity.setTime(time.substring(0,time.indexOf(" ")));
        }
        else{
            activity = new Activity();
        }
        return activity;
    }
    //列表
    @RequestMapping(value = "activity_list",method = RequestMethod.GET)
    public String userList(){
        return "user_activity_list";
    }
    //详情
    @RequestMapping(value = "activity_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "user_activity_detail";
    }
    //获取添加--修改用户表单
    @RequestMapping(value = "activity_form",method = RequestMethod.GET)
    public String Form(Model model){
        List<Place> placeList = placeDao.getByStatus();
        model.addAttribute("placeList",placeList);
        return "user_activity_form";
    }
    //添加
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Activity activity, RedirectAttributes attributes, Model model,HttpServletRequest request){
        AdminUser user = (AdminUser) request.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        activity.setClubId(user.getClubId());
        BaseResult save = activityService.save(activity);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/activity/activity_list";
        }
        //保存失败
        else {
            List<Place> placeList = placeDao.getByStatus();
            model.addAttribute("placeList",placeList);
            model.addAttribute("save",save);
            return "user_activity_form";
        }
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            activityService.deleteMulti(ids);
            baseResult=BaseResult.success("撤回活动申请成功");
        }
        else {
            baseResult=BaseResult.fail("撤回活动申请失败");
        }
        return baseResult;
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<GroupApplications> pageInfo(HttpServletRequest request, Activity activity){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        String strClubId = request.getParameter("clubId");
        activity.setClubId(Long.parseLong(strClubId));

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<GroupApplications> pageInfo = activityService.dataTableSearch(start,length,draw,activity);
        return pageInfo;
    }
}
