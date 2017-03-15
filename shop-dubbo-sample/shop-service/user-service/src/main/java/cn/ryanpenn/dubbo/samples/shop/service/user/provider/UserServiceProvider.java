package cn.ryanpenn.dubbo.samples.shop.service.user.provider;

import cn.ryanpenn.dubbo.samples.shop.service.user.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * UserServiceProvider
 */
public class UserServiceProvider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        System.out.println("UserServiceProvider start...");

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
