package com.shp.web.admin.web.controller;

import com.shp.commons.constant.PageInfo;
import com.shp.domain.Club;
import com.shp.web.admin.service.ClubService;
import com.shp.web.admin.service.UserClubService;
import com.shp.web.admin.vo.CountClubVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user_club")
public class UserClubController {
    @Autowired
    private ClubService clubService;
    @Autowired
    private UserClubService userClubService;

    @ModelAttribute
    public Club getClub(Long id){
        Club club;
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
    //详情
    @RequestMapping(value = "user_club_detail",method = RequestMethod.GET)
    public String adminDetail(){
        return "user_club_detail";
    }
    //社团一览
    @RequestMapping(value = "user_club_list",method = RequestMethod.GET)
    public String userClubCount(){
        return "user_club_list";
    }
    //分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<CountClubVo> countClub (HttpServletRequest request, Club club){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<CountClubVo> pageInfo = clubService.countClub(start,length,draw,club);
        return pageInfo;
    }

    //社联管理员社团一览
    @RequestMapping(value = "admin_club_list",method = RequestMethod.GET)
    public String userClubCount1(){
        return "admin_club_list";
    }
    //社联管理员修改星级
    @RequestMapping(value = "starDetail",method = RequestMethod.GET)
    public String starDetail(){
        return "star_detail";
    }
    @RequestMapping(value = "updateStar",method = RequestMethod.POST)
    public String updateStar(Long clubId,Integer star){
        userClubService.updateStar(clubId,star);
        return "admin_club_list";
    }
}
