package com.shp.web.ui.web.controller;

import com.shp.domain.News;
import com.shp.web.ui.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: 新闻功能
 * @Author: sunhp
 * @Date: 2020/5/20 9:42
 */
@Controller
@RequestMapping("news")
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

    @RequestMapping(value = "queryNews",method = RequestMethod.GET)
    public String queryNews(Model model){
        List<News> newsList = newsService.queryNews();
        if(newsList!=null && newsList.size()>0){
            model.addAttribute("newsList",newsList);
        }
        return "news";
    }

    //详情
    @RequestMapping(value = "newsDetail",method = RequestMethod.GET)
    public String getMyDetail(){
        return "news_detail";
    }
}
