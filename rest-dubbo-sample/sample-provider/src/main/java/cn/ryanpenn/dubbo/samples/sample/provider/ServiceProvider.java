package cn.ryanpenn.dubbo.samples.sample.provider;

import cn.ryanpenn.dubbo.samples.sample.api.RestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvider {

    static void printMemory(RestService restService) {
        long maxM = Runtime.getRuntime().maxMemory();
        long totalM = Runtime.getRuntime().totalMemory();
        long freeM = Runtime.getRuntime().freeMemory();
        System.out.println("maxMemory=" + restService.dataSizeFormat(maxM)
                + ", totalMemory=" + restService.dataSizeFormat(totalM)
                + ", freeMemory=" + restService.dataSizeFormat(freeM));
    }

    // 响应时间优先的并发收集器
    // java -Xmx2000m -Xms2000m -Xmn2g -Xss512k -XX:+UseG1GC \
    // -jar target/dubbo-sample-provider-1.0-SNAPSHOT.jar --spring.profiles.active=dev
    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.start();

        RestService restService = (RestService) context.getBean("restService");
        printMemory(restService);
        System.out.println("Provider start...");

        System.in.read();
    }

}
