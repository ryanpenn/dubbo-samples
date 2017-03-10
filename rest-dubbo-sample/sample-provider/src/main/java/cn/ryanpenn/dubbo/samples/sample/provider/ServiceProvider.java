package cn.ryanpenn.dubbo.samples.sample.provider;

import cn.ryanpenn.dubbo.samples.sample.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvider {

    // 响应时间优先的并发收集器
    // java -Xmx2000m -Xms2000m -Xmn2g -Xss512k -XX:+UseG1GC \
    // -jar target/dubbo-sample-provider-1.0-SNAPSHOT.jar --spring.profiles.active=dev
    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.start();

        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println("Provider start...");

        System.out.println("maxMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().maxMemory())
                + ", totalMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().totalMemory())
                + ", freeMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().freeMemory()));

        System.in.read();
    }

}
