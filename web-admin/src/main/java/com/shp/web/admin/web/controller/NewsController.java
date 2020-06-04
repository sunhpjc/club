package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.News;
import com.shp.domain.User;
import com.shp.web.admin.service.NewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @ModelAttribute
    public News getById(Long id){
        News news = null;
        if(id!=null){
            news=newsService.getById(id);
        }
        else{
            news = new News();
        }
        return news;
    }
    //列表
    @RequestMapping(value = "news_list",method = RequestMethod.GET)
    public String List(){
        return "news_list";
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            newsService.deleteMulti(ids);
            baseResult=BaseResult.success("删除成功");
        }
        else {
            baseResult=BaseResult.fail("删除失败");
        }
        return baseResult;
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<News> pageInfo(HttpServletRequest request, News news){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<News> pageInfo = newsService.dataTableSearch(start,length,draw,news);
        return pageInfo;
    }


    //以下是社团管理员功能
    //新增新闻==获取表单
    @RequestMapping(value = "getForm",method = RequestMethod.GET)
    public String getForm(){
        return "user_news_form";
    }
    //保存新闻
    @RequestMapping(value = "saveNews",method = RequestMethod.POST)
    public String saveNews(String newsTitle,String newsContent,HttpServletRequest request){
        News news = new News();
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        Long clubId = adminUser.getClubId();

        news.setClubId(clubId);
        news.setNewsTitle(newsTitle);
        news.setNewsContent(newsContent);
        news.setNewsStatus(1);

        newsService.saveNews(news);
        return "redirect:/news/my_news_list";
    }
    //展示本社团新闻列表
    @RequestMapping(value = "my_news_list",method = RequestMethod.GET)
    public String getMyList(){
        return "my_news_list";
    }
    //分页
    @ResponseBody
    @RequestMapping(value = "mypage",method = RequestMethod.GET)
    public PageInfo<News> pageInfo1(HttpServletRequest request, News news){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        news.setClubId(adminUser.getClubId());

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<News> pageInfo = newsService.dataTableSearch1(start,length,draw,news);
        return pageInfo;
    }

    //详情
    @RequestMapping(value = "my_news_detail",method = RequestMethod.GET)
    public String getMyDetail(){
        return "my_news_detail";
    }
}
