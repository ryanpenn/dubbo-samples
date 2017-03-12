package cn.ryanpenn.dubbo.samples.sample.provider.mixed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * MixedServiceProvider
 */
public class MixedServiceProvider {

    public static void main(String[] args) throws IOException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("MixedService start...");

        System.in.read();
        System.out.println("bye!");
        System.exit(0);
    }

}
