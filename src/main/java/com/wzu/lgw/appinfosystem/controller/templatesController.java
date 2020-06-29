package com.wzu.lgw.appinfosystem.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class templatesController {

    @RequestMapping("/personInfo")
    public String personinfo(){
        return "developer/personInfo.html";
    }

    @RequestMapping("/backpersonInfo")
    public String backpersoninfo(){
        return "/backmanage/personInfo.html";
    }

    @RequestMapping("/password")
    public String updatepassword(){
        return "/backmanage/modify_password.html";
    }

    @RequestMapping("/main.html")
    public String backmian(){
        return "/backmanage/mian.html";
    }

    @RequestMapping("/devmian.html")
    public String devmain(){
        return "/developer/main.html";
    }

    @RequestMapping("/tempappinfoadd")
    public String appinfoadd(){
        return "/developer/appinfoadd.html";
    }
    @RequestMapping("/appCheck")
    public String appCheck(){
        return "/backmanage/applist";
    }

    @RequestMapping("/loginerror")
    public String login403(){
        return "login";
    }
    @RequestMapping("/back")
    public String backlist(){
        return "/developer/appinfolist";
    }

    @RequestMapping("/userInfo")
    public String userInfo(){
        return "developer/devuserinfo";
    }

}
