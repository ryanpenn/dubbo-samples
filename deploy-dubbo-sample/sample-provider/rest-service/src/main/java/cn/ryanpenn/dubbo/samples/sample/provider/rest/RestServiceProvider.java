package cn.ryanpenn.dubbo.samples.sample.provider.rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * RestServiceProvider
 */
public class RestServiceProvider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("RestService start...");

        System.in.read();
        System.out.println("bye!");
        System.exit(0);
    }
}
