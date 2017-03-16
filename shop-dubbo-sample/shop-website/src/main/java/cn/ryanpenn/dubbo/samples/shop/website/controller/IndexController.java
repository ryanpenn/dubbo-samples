package cn.ryanpenn.dubbo.samples.shop.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title","Welcome");
        model.addAttribute("message","Hello visitor.");
        return "home";
    }

}
