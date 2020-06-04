package com.shp.web.admin.web.controller;

import com.shp.commons.constant.ConstantUtils;
import com.shp.commons.constant.PageInfo;
import com.shp.commons.dto.BaseResult;
import com.shp.domain.AdminUser;
import com.shp.domain.Club;
import com.shp.domain.Finance;
import com.shp.domain.User;
import com.shp.web.admin.service.FinanceService;
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
@RequestMapping(value = "finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @ModelAttribute
    public Finance getFinance(Long id){
        Finance finance = null;
        if(id!=null){
            finance=financeService.getById(id);
        }
        else{
            finance = new Finance();
        }
        return finance;
    }

    //列表
    @RequestMapping(value = "finance_list",method = RequestMethod.GET)
    public String List(){
        return "finance_list";
    }
    //删除
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteMulti(String idArray){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(idArray)){
            String[] ids = idArray.split(",");
            financeService.deleteMulti(ids);
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
    public PageInfo<Finance> pageInfo(HttpServletRequest request, Finance finance){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);

        //封装dataTable数据
        PageInfo<Finance> pageInfo = financeService.dataTableSearch(start,length,draw,finance);
        return pageInfo;
    }

    /*
    * 社团管理员方法
    * */
    //列表
    @RequestMapping(value = "user_finance_list",method = RequestMethod.GET)
    public String userList(){
        return "user_finance_list";
    }
    //GET方法---分页
    @ResponseBody
    @RequestMapping(value = "user_page",method = RequestMethod.GET)
    public PageInfo<Finance> pageInfo1(HttpServletRequest request, Finance finance){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        String clubId1 = request.getParameter("clubId");

        int draw = strDraw == null?0:Integer.parseInt(strDraw);
        int start = strStart == null?0:Integer.parseInt(strStart);
        int length = strLength == null?10:Integer.parseInt(strLength);
        long clubId = Long.parseLong(clubId1);
        finance.setClubId(clubId);

        //封装dataTable数据
        PageInfo<Finance> pageInfo = financeService.dataTableSearch_user(start,length,draw,finance);
        return pageInfo;
    }
    //添加表单
    @RequestMapping(value = "user_finance_form",method = RequestMethod.GET)
    public String userFinanceForm(){
        return "user_finance_form";
    }
    //添加
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Finance finance, RedirectAttributes attributes, Model model, HttpServletRequest httpServletRequest){
        //获取用户session
        AdminUser adminUser=(AdminUser) httpServletRequest.getSession().getAttribute(ConstantUtils.ADMINUSER_SESSION);
        Long clubId = adminUser.getClubId();
        finance.setClubId(clubId);

        BaseResult save = financeService.save(finance);
        //保存成功
        if(save.getStatus()==STATUS_SUCCESS){
            attributes.addFlashAttribute("save",save);
            return "redirect:/finance/user_finance_list";
        }
        //保存失败
        else {
            model.addAttribute("save",save);
            return "user_finance_form";
        }
    }
}
