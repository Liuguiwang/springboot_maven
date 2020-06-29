package com.wzu.lgw.appinfosystem.controller;
import com.wzu.lgw.appinfosystem.pojo.BackendUser;
import com.wzu.lgw.appinfosystem.pojo.DevUser;
import com.wzu.lgw.appinfosystem.service.BackendUserService;
import com.wzu.lgw.appinfosystem.service.DevUserService;
import com.wzu.lgw.appinfosystem.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    BackendUserService backendUserService;
    @Autowired
    DevUserService devUserService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/backlogin.html")
    public String backlogin(BackendUser backendUser, HttpSession session, HttpServletRequest request) {
        System.out.println(backendUser.getUserCode() + backendUser.getUserPassword());
        BackendUser backendUser1 = backendUserService.backlogin(backendUser);
        if (backendUser1 != null) {
            session.setAttribute(Constants.backuserinfo, backendUser1);
            return "redirect:/back/welcome";
        }
        request.setAttribute("message", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("/devlogin.html")
    public String devlogin(DevUser devUser, HttpSession session, HttpServletRequest request) {
        System.out.println(devUser.getDevCode() + devUser.getDevPassword());
        DevUser devUser1 = devUserService.devlogin(devUser);
        if (devUser1 != null) {
            session.setAttribute(Constants.devuserinfo, devUser1);
            return "redirect:/dev/welcome";
        }
        request.setAttribute("message", "用户名或密码错误");
        return "login";
    }


    @RequestMapping(value="/dev/welcome")
    public String devmain(HttpSession session){
        if(session.getAttribute(Constants.devuserinfo) == null){
            return "errorpage/403";
        }
        return "developer/welcome";
    }

    @RequestMapping(value="/back/welcome")
    public String bCKmain(HttpSession session){
        if(session.getAttribute(Constants.backuserinfo) == null){
            return "errorpage/403";
        }
        return "backmanage/welcome";
    }
    @RequestMapping("/logout.do")
    public String doLogout(HttpSession session) {
        session.removeAttribute(Constants.backuserinfo);
        session.removeAttribute(Constants.devuserinfo);
        return "login";
    }

}
