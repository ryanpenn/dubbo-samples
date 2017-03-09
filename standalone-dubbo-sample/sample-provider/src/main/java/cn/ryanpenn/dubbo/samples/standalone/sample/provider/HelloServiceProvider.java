package cn.ryanpenn.dubbo.samples.standalone.sample.provider;

import cn.ryanpenn.dubbo.samples.standalone.sample.api.HelloService;
import cn.ryanpenn.dubbo.samples.standalone.sample.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * HelloServiceProvider
 */
public class HelloServiceProvider implements HelloService {
    @Override
    public String sayHello(String name) {
        return "HelloServiceProvider say: Hello " + name;
    }

    @Override
    public User register(String name, int age) {
        return new User(name, age);
    }

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();

        HelloService service = (HelloService) context.getBean("helloService");
        if (service != null) {
            System.out.println(service.sayHello("Provider"));
        }

        System.in.read();
    }
}
