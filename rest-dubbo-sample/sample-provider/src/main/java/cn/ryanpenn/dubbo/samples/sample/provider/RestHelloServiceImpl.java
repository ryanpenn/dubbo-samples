package cn.ryanpenn.dubbo.samples.sample.provider;

import cn.ryanpenn.dubbo.samples.sample.api.HelloService;
import cn.ryanpenn.dubbo.samples.sample.api.RestHelloService;
import cn.ryanpenn.dubbo.samples.sample.api.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * RestHelloServiceImpl
 */
public class RestHelloServiceImpl implements RestHelloService {

    @Autowired
    HelloService helloService;

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    @Override
    public List<User> getUsers() {
        return helloService.getUsers();
    }

    @Override
    public String dataSizeFormat(long size) {
        return helloService.dataSizeFormat(size);
    }
}
