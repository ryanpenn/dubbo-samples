package cn.ryanpenn.dubbo.samples.sample.consumer.web.controller;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.mixed.MixedContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import cn.ryanpenn.dubbo.samples.sample.api.rest.RestContactService;
import cn.ryanpenn.dubbo.samples.sample.consumer.web.viewmodel.RestResult;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private RestContactService restContactService;
    @Autowired
    private MixedContactService mixedContactService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public RestResult info() {
        Map<String, String> infoMap = new HashMap<>();

        if (contactService != null) {
            infoMap.put("contactService", contactService.info());
        }

        if (restContactService != null) {
            infoMap.put("restContactService", restContactService.info());
        }

        if (mixedContactService != null) {
            infoMap.put("mixedContactService", mixedContactService.info());
        }

        return RestResult.builder().code(1).msg("调用成功").data(infoMap).build();
    }

    @RequestMapping("/{type}/contact")
    @ResponseBody
    public List<Contact> list(@PathVariable String type) throws ExecutionException, InterruptedException {
        if ("dubbo".equalsIgnoreCase(type)) {
            contactService.list(); // <dubbo:method name="list" async="true"/>
            Future<List<Contact>> pFuture = RpcContext.getContext().getFuture();

            // do other things ...

            return pFuture.get();
        } else if ("rest".equalsIgnoreCase(type)) {
            return restContactService.list();
        } else if ("mixed".equalsIgnoreCase(type)) {
            return mixedContactService.list();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/{type}/contact/add", method = RequestMethod.GET)
    public ModelAndView add(@PathVariable String type, ModelAndView mv) {
        mv.addObject("type", type);
        if ("dubbo".equalsIgnoreCase(type)) {
            mv.addObject("info", contactService.info());
        } else if ("rest".equalsIgnoreCase(type)) {
            mv.addObject("info", restContactService.info());
        } else if ("mixed".equalsIgnoreCase(type)) {
            mv.addObject("info", mixedContactService.info());
        }
        mv.setViewName("add_contact");
        return mv;
    }

    @RequestMapping(value = "/{type}/contact/add", method = RequestMethod.POST)
    public String save(@PathVariable String type, Contact contact, Model model) {
        String result = "添加失败!";

        if (contact != null) {
            if ("dubbo".equalsIgnoreCase(type)) {
                contactService.save(contact);
                result = "contactService.save() successful";
            } else if ("rest".equalsIgnoreCase(type)) {
                restContactService.save(contact);
                result = "restContactService.save() successful";
            } else if ("mixed".equalsIgnoreCase(type)) {
                mixedContactService.save(contact);
                result = "mixedContactService.save() successful";
            }
        }

        model.addAttribute("type", type);
        model.addAttribute("result", result);

        return "result";
    }
}
