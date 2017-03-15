package cn.ryanpenn.dubbo.samples.shop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ShopApp
 */
public class ShopApp {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("ShopApp start...");

        // 注意：这里不能使用 new UserServiceConsumer() 创建对象
        UserServiceConsumer consumer = context.getBean(UserServiceConsumer.class);
        consumer.register();
        consumer.login();

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }
}
