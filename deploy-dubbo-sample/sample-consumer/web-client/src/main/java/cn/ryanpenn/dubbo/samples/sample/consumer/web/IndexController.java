package cn.ryanpenn.dubbo.samples.sample.consumer.web;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.mixed.MixedContactService;
import cn.ryanpenn.dubbo.samples.sample.api.rest.RestContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 */
@RestController
public class IndexController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private RestContactService restContactService;
    @Autowired
    private MixedContactService mixedContactService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        String result = "service is null";
        if (contactService != null) {
            result = contactService.info();
        }
        return result;
    }
}
