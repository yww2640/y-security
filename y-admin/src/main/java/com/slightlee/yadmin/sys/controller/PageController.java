package com.slightlee.yadmin.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: 欢迎页
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 2:04
 */
@Controller
public class PageController {

    /**
     *  欢迎页
     */
    @RequestMapping("/{page}")
    public String index(@PathVariable String page){
        return "views/" + page;
    }

    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "views/" + "index";
    }


    /**
     *  登录
     */
    @RequestMapping("login.html")
    public String login(){
        return "views/" + "login";
    }


    /**
     * 控制台 跳转页面
     */
    @RequestMapping("/{url}/{page}")
    public String index(@PathVariable String url,@PathVariable String page){
        return "views/"+ url  + "/" + page;
    }




    /**
     *  用户 角色 菜单 跳转页面
     */
    @RequestMapping("/sys/{url}/{page}")
    public String userPage(@PathVariable String url,@PathVariable String page){
        return "views/sys"+"/"+url+"/" + page;
    }

}
