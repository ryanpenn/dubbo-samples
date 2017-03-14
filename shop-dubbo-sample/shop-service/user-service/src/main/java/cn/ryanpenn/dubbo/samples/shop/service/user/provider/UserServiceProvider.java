package cn.ryanpenn.dubbo.samples.shop.service.user.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * UserServiceProvider
 */
public class UserServiceProvider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContaxt.xml");

        System.out.println("UserServiceProvider start...");
        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
