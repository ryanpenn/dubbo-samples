package cn.ryanpenn.dubbo.samples.sample.provider.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * DubboServiceProvider
 */
public class DubboServiceProvider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("DubboService start...");

        System.in.read();
        System.out.println("bye!");
        System.exit(0);
    }

}
