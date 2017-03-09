package cn.ryanpenn.dubbo.samples.sample.consumer;


import cn.ryanpenn.dubbo.samples.sample.api.RestService;
import cn.ryanpenn.dubbo.samples.sample.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.List;

public class ServiceConsumer {

    RestService restService;

    ServiceConsumer(RestService restService) {
        this.restService = restService;
    }

    void hello() {
        String hello = restService.sayHello("tom");
        System.out.println(hello);
    }

    void printList() {
        List<User> list = restService.getUsers();
        list.forEach(System.out::println);
    }

    void loopInvoke(int times) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        for (int i = 0; i < times; i++) {
            restService.sayHello("loop-" + i);
        }
        endTime = System.currentTimeMillis();

        DecimalFormat decimalFormat = new DecimalFormat(".00");
        System.out.println("平均耗时: "
                + decimalFormat.format((float) (endTime - startTime) / times) + "ms/次");
    }

    static void printMemory(RestService restService) {
        long maxM = Runtime.getRuntime().maxMemory();
        long totalM = Runtime.getRuntime().totalMemory();
        long freeM = Runtime.getRuntime().freeMemory();
        System.out.println("maxMemory=" + restService.dataSizeFormat(maxM)
                + ", totalMemory=" + restService.dataSizeFormat(totalM)
                + ", freeMemory=" + restService.dataSizeFormat(freeM));
    }

    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        context.start();

        RestService restService = (RestService) context.getBean("restService");
        printMemory(restService);
        System.out.println("ServiceConsumer start...");

        ServiceConsumer serviceConsumer = new ServiceConsumer(restService);
        serviceConsumer.hello();
        serviceConsumer.printList();

        serviceConsumer.loopInvoke(10);

        System.in.read();
        System.out.println("bye!");
    }

}
