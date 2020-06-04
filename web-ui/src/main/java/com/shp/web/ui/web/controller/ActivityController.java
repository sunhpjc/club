package com.shp.web.ui.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Activity;
import com.shp.domain.User;
import com.shp.web.ui.service.ActivityService;
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
 * @Date: 2020/5/13 10:19
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityService activityService;

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
    public String activityList(){
        return "activity_list";
    }

    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<Activity> pageInfo(HttpServletRequest request, Activity activity){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Activity> pageInfo = activityService.dataTableSearch(start,length,draw,activity);
        return pageInfo;
    }

    //参加活动
    @RequestMapping(value = "joinActivity",method = RequestMethod.GET)
    public String joinActivity(Long activityId, HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION);
        Long userId = user.getUserId();

        int num = activityService.selectActivity(activityId,userId);
        logger.info("================{}",num);
        if(num != 0){
            BaseResult save = BaseResult.fail("你已经参加该活动了");
            model.addAttribute("save",save);
            return "activity_list";
        }

        BaseResult save = activityService.joinActivity(userId,activityId);
        model.addAttribute("save",save);
        return "activity_list";
    }

    //查看详情
    @RequestMapping(value = "activity_detail",method = RequestMethod.GET)
    public String activityDetail(){
        return "activity_detail";
    }

    //活动列表
    @RequestMapping(value = "my_activity_list",method = RequestMethod.GET)
    public String myActivityList(){
        return "my_activity_list";
    }
    //GET方法---我的活动分页
    @ResponseBody
    @RequestMapping(value = "myPage",method = RequestMethod.GET)
    public PageInfo<Activity> pageInfo1(HttpServletRequest request){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION);
        Long userId = user.getUserId();

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Activity> pageInfo = activityService.queryActivity(start,length,draw,userId);
        return pageInfo;
    }
}
