package com.shp.web.admin.web.controller;

import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.Comments;
import com.shp.web.admin.service.CommentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @ModelAttribute
    public Comments getById(Long id){
        Comments comments = null;
        if(id!=null){
            comments=commentsService.getById(id);
        }
        else{
            comments = new Comments();
        }
        return comments;
    }
    //列表
    @RequestMapping(value = "comments_list",method = RequestMethod.GET)
    public String List(){
        return "comments_list";
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            commentsService.deleteMulti(ids);
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
    public PageInfo<Comments> pageInfo(HttpServletRequest request, Comments comments){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Comments> pageInfo = commentsService.dataTableSearch(start,length,draw,comments);
        return pageInfo;
    }
    //POST方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageInfo<Comments> pageInfo1(HttpServletRequest request,Comments comments){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Comments> pageInfo = commentsService.dataTableSearch(draw,start,length,comments);
        return pageInfo;
    }
}
