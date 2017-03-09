package cn.ryanpenn.dubbo.samples.standalone.sample.consumer;

import cn.ryanpenn.dubbo.samples.standalone.sample.api.HelloService;
import cn.ryanpenn.dubbo.samples.standalone.sample.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * HelloServiceConsumer
 */
public class HelloServiceConsumer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();

        HelloService service = (HelloService) context.getBean("helloService");
        if (service != null) {
            System.out.println(service.sayHello("Consumer"));

            User user = service.register("Tom", 20);
            System.out.println(user.toString());
        }

        System.in.read();
    }
}
