package cn.ryanpenn.dubbo.samples.shop.website.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * InfoController
 */
@RestController
public class InfoController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(){

        return "shop-website";
    }
}
