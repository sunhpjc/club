package com.shp.web.ui.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.domain.User;
import com.shp.web.ui.dao.ClubDao;
import com.shp.web.ui.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: sunhp
 * @Date: 2020/5/11 6:57
 */
@Controller
@RequestMapping("club")
public class ClubController {
    @Autowired
    private ClubService clubService;
    @Autowired
    private ClubDao clubDao;

    @ModelAttribute
    public Club getClub(Long id){
        Club club = null;
        if(id!=null){
            club=clubService.getClubById(id);
            String time=club.getFoundtime();
            club.setFoundtime(time.substring(0,time.indexOf(" ")));
        }
        else{
            club = new Club();
        }
        return club;
    }
    //列表
    @RequestMapping(value = "club_list",method = RequestMethod.GET)
    public String userList(){
        return "club_list";
    }

    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<Club> pageInfo(HttpServletRequest request, Club club){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Club> pageInfo = clubService.dataTableSearch(start,length,draw,club);
        return pageInfo;
    }

    //详情
    @RequestMapping(value = "club_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "club_detail";
    }

    /***
     * 加入社团，添加申请
     * @return
     */
    @RequestMapping(value = "getJoinForm",method = RequestMethod.GET)
    public String join(HttpServletRequest request, Model model){

        User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION);
        Long userId = user.getUserId();
        Long clubId = Long.parseLong(request.getParameter("clubId"));

        int num = clubDao.join(userId, clubId);
        if(num != 0){
            BaseResult save = BaseResult.fail("你已经加入该社团");
            model.addAttribute("save",save);
            return "club_list";
        }
        model.addAttribute("clubId",clubId);
        model.addAttribute("userId",userId);
        return "user_join";
    }

    /**
     * 添加申请
     * @param clubId
     * @param userId
     * @param applicationDesc
     * @param attributes
     * @return
     */
    @RequestMapping(value = "saveApplication",method = RequestMethod.POST)
    public String saveApplication(Long clubId, Long userId, String applicationDesc, RedirectAttributes attributes){
        BaseResult save = clubService.join(userId,clubId,applicationDesc);
        attributes.addFlashAttribute("save",save);
        return "redirect:/club/club_list";
    }

    /***
     * 退出社团，添加申请
     * @return
     */
    @RequestMapping(value = "getExitForm",method = RequestMethod.GET)
    public String exit(HttpServletRequest request, Model model){

        User user = (User) request.getSession().getAttribute(ConstantUtils.USER_SESSION);
        Long userId = user.getUserId();
        Long clubId = Long.parseLong(request.getParameter("clubId"));

        int num = clubDao.join(userId, clubId);
        if(num == 0){
            BaseResult save = BaseResult.fail("你还未加入该社团");
            model.addAttribute("save",save);
            return "club_list";
        }
        model.addAttribute("clubId",clubId);
        model.addAttribute("userId",userId);
        return "user_exit";
    }

    /**
     * 添加退出申请
     * @param clubId
     * @param userId
     * @param applicationDesc
     * @param attributes
     * @return
     */
    @RequestMapping(value = "saveApplicationExit",method = RequestMethod.POST)
    public String saveApplicationExit(Long clubId, Long userId, String applicationDesc, RedirectAttributes attributes){
        BaseResult save = clubService.join(userId,clubId,applicationDesc);
        attributes.addFlashAttribute("save",save);
        return "redirect:/club/club_list";
    }
}
