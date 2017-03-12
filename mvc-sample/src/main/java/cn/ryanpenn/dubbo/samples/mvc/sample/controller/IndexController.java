package cn.ryanpenn.dubbo.samples.mvc.sample.controller;

import cn.ryanpenn.dubbo.samples.mvc.sample.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * IndexController
 */
@RestController
public class IndexController {

    private List<User> userList = new ArrayList<>();

    public IndexController(){
        userList.add(User.builder().id(1).name("test").email("test@gmail.com").build());
        userList.add(User.builder().id(2).name("producer").email("producer@gmail.com").build());
    }

    @RequestMapping("info")
    public String info(){
        return "IndexController info.";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> list(){
        return userList;
    }
}
