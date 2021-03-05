package com.zxr.mygraduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/zxr")
@Controller
public class HtmlController {
    @RequestMapping("/index")
    public String backIndex(){
        return "index";
    }

      @RequestMapping("/welcome")
      public String welcomeIndex(){
         return "welcome";
      }
     @RequestMapping("/addPage")
    public String addPageIndex(){
        return "addPage";
    }
    @RequestMapping("/adminInfo")
    public String adminInfo(){
        return "admin-info";
    }
    @RequestMapping("/editPage")
    public String editPage(){
        return "editPage";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/rateDetail")
    public String rateDetail(){
        return "rate-detail";
    }
    @RequestMapping("/useloan")
    public String useloan(){
        return "useloan";
    }
    @RequestMapping("/useDetail")
    public String useDetail(){
        return "use-detail";
    }
    @RequestMapping("/suggest")
    public String suggest(){
        return "suggest";
    }
    @RequestMapping("/rateList")
    public String rateList(){
        return "rate-list";
    }
    @RequestMapping("/menu2")
    public String menu2(){
        return "menu2";
    }
    @RequestMapping("/commentIndex")
    public String commentIndex(){
        return "commentIndex";
    }
    @RequestMapping("/categoryIndex")
    public String categoryIndex(){
        return "categoryIndex";
    }
    @RequestMapping("/articleAdd")
    public String articleAdd(){
        return "article-add";
    }
    @RequestMapping("/addPostCategory")
    public String addPostCategory(){
        return "addPostCategory";
    }
    @RequestMapping("/editRate")
    public String editRate(){
        return "editRate";
    }
    @RequestMapping("/menu1")
    public String menu1(){
        return "menu1";
    }
    @RequestMapping("/menu0")
    public String menu0(){
        return "menu0";
    }
    @RequestMapping("/suggest1")
    public String suggest1(){
        return "suggest1";
    }
}
