package cn.ryanpenn.dubbo.sample.provider;

import cn.ryanpenn.dubbo.sample.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvider {

    static void printMemory(DemoService demoService) {
        long maxM = Runtime.getRuntime().maxMemory();
        long totalM = Runtime.getRuntime().totalMemory();
        long freeM = Runtime.getRuntime().freeMemory();
        System.out.println("maxMemory=" + demoService.dataSizeFormat(maxM)
                + ", totalMemory=" + demoService.dataSizeFormat(totalM)
                + ", freeMemory=" + demoService.dataSizeFormat(freeM));
    }

    // 响应时间优先的并发收集器
    // java -Xmx2000m -Xms2000m -Xmn2g -Xss512k -XX:+UseG1GC \
    // -jar target/dubbo-sample-provider-1.0-SNAPSHOT.jar --spring.profiles.active=dev
    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        printMemory(demoService);
        System.out.println("Provider start...");

        System.in.read();
    }

}
