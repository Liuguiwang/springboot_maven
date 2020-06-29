package com.wzu.lgw.appinfosystem.controller;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.wzu.lgw.appinfosystem.dao.BackendUserMapper;
import com.wzu.lgw.appinfosystem.pojo.AppCategory;
import com.wzu.lgw.appinfosystem.pojo.BackendUser;
import com.wzu.lgw.appinfosystem.pojo.DataDictionary;
import com.wzu.lgw.appinfosystem.service.AppCategoryService;
import com.wzu.lgw.appinfosystem.service.BackendUserService;
import com.wzu.lgw.appinfosystem.service.DataDictionaryService;
import com.wzu.lgw.appinfosystem.tools.Constants;
import com.wzu.lgw.appinfosystem.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/backuser")
public class BackUserlistController {

    @Resource
    private DataDictionaryService dataDictionaryService;
    @Resource
    private AppCategoryService appCategoryService;
    @Autowired
    private BackendUserMapper backendUserMapper;
    @Resource
    private BackendUserService backendUserService;
    @RequestMapping("/list")
    public String getbackUserlist(Model model, HttpSession session, @RequestParam(value="pageIndex",required=false) String pageIndex){
        Date date=new Date();
        List<BackendUser> backUserlist=null;
        List<DataDictionary> userTypeList=null;
        //页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        //总数量（表）
        int totalCount = 0;
        try {
            totalCount = backendUserMapper.count();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        try {
            backUserlist=backendUserMapper.selectAll(currentPageNo-1,pageSize);
            userTypeList=this.getDataDictionaryList("USER_TYPE");
        }catch (Exception e){
            e.printStackTrace();
        }
        int userType=((BackendUser)session.getAttribute(Constants.backuserinfo)).getUserType();
        if(userType==1)
        {
            model.addAttribute("date",date);
            model.addAttribute("pages",pages);
            model.addAttribute("backUserlist",backUserlist);
            model.addAttribute("userTypeList",userTypeList);
            return "backmanage/backadminlist";
        }
        model.addAttribute("date",date);
        model.addAttribute("pages",pages);
        model.addAttribute("backUserlist",backUserlist);
        return "backmanage/backUserlist";
    }

    public List<DataDictionary> getDataDictionaryList(String typeCode){
        List<DataDictionary> dataDictionaryList = null;
        try {
            dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataDictionaryList;
    }

    /**
     * 根据typeCode查询出相应的数据字典列表
     * @param pid
     * @return
     */
    @RequestMapping(value="/datadictionarylist.json",method= RequestMethod.GET)
    @ResponseBody
    public List<DataDictionary> getDataDicList (@RequestParam String tcode){
//        logger.debug("getDataDicList tcode ============ " + tcode);
        return this.getDataDictionaryList(tcode);
    }

    /**
     * 根据parentId查询出相应的分类级别列表
     * @param pid
     * @return
     */
    @RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
    @ResponseBody
    public List<AppCategory> getAppCategoryList (@RequestParam String pid){
//        logger.debug("getAppCategoryList pid ============ " + pid);
        if(pid.equals("")) pid = null;
        return getCategoryList(pid);
    }

    public List<AppCategory> getCategoryList (String pid){
        List<AppCategory> categoryLevelList = null;
        try {
            categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid==null?null:Integer.parseInt(pid));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoryLevelList;
    }

    @RequestMapping("/adduser")
    public String addUser(
//            @RequestParam(value="userCode",required=false) String userCode,
//                          @RequestParam(value="userName",required=false) String userName,
//                          @RequestParam(value="userType",required=false) String userType,
//                          @RequestParam(value="userPassword",required=false) String userPassword,
            BackendUser backendUser,
            HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= null;
        int flag=backendUserService.addUser(backendUser);
        if(flag>0){
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('添加用户成功！')</script>");
            return "redirect:/backuser/list";
        }
        out.print("<script>alert('添加用户失败，请重新添加！')</script>");
        return "redirect:/backuser/list";
    }

    @RequestMapping(value="/delUser.json")
    @ResponseBody
    public Object delApp(@RequestParam String id){
//        logger.debug("delApp appId===================== "+id);
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(id)){
            resultMap.put("delResult", "notexist");
        }else{
            try {
                if(backendUserService.delUser(Integer.parseInt(id))>0){
                    resultMap.put("delResult", "true");
                }
                else
                    resultMap.put("delResult", "false");
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/usermodify")
    public String usermodify(@RequestParam("id") String id,Model model){
        BackendUser backendUser=null;
        List<DataDictionary> userTypeList=null;
        try {
            backendUser=backendUserService.getuserById(Integer.parseInt(id));
            userTypeList=this.getDataDictionaryList("USER_TYPE");
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("userInfo",backendUser);
        model.addAttribute("userTypeList",userTypeList);
        return "backmanage/userinfomodify";
    }
}
