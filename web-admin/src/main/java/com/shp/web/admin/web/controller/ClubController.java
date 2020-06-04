package com.shp.web.admin.web.controller;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Club;
import com.shp.web.admin.service.ClubService;
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
@RequestMapping(value = "club")
public class ClubController {
    @Autowired
    private ClubService clubService;
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
    //详情
    @RequestMapping(value = "club_detail",method = RequestMethod.GET)
    public String adminDetail(Long id){
        return "club_detail";
    }
    //获取添加--修改用户表单
    @RequestMapping(value = "club_form",method = RequestMethod.GET)
    public String clubForm(){
        return "club_form";
    }
    //添加
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Club club, RedirectAttributes attributes, Model model){
        BaseResult save = clubService.save(club);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/club/club_list";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "club_form";
        }
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            clubService.deleteMulti(ids);
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
    //POST方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageInfo<Club> pageInfo1(HttpServletRequest request,Club club){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Club> pageInfo = clubService.dataTableSearch(draw,start,length,club);
        return pageInfo;
    }
}
