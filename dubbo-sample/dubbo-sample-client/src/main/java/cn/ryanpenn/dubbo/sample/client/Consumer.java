package cn.ryanpenn.dubbo.sample.client;


import cn.ryanpenn.dubbo.sample.api.DemoService;
import cn.ryanpenn.dubbo.sample.api.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.List;

public class Consumer {

    DemoService demoService;

    Consumer(DemoService demoService) {
        this.demoService = demoService;
    }

    void hello() {
        String hello = demoService.sayHello("tom");
        System.out.println(hello);
    }

    void printList() {
        List<User> list = demoService.getUsers();
        list.forEach(System.out::println);
    }

    void loopInvoke(int times) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        for (int i = 0; i < times; i++) {
            demoService.sayHello("loop-" + i);
        }
        endTime = System.currentTimeMillis();

        DecimalFormat decimalFormat = new DecimalFormat(".00");
        System.out.println("平均耗时: "
                + decimalFormat.format((float) (endTime - startTime) / times) + "ms/次");
    }

    static void printMemory(DemoService demoService) {
        long maxM = Runtime.getRuntime().maxMemory();
        long totalM = Runtime.getRuntime().totalMemory();
        long freeM = Runtime.getRuntime().freeMemory();
        System.out.println("maxMemory=" + demoService.dataSizeFormat(maxM)
                + ", totalMemory=" + demoService.dataSizeFormat(totalM)
                + ", freeMemory=" + demoService.dataSizeFormat(freeM));
    }

    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        printMemory(demoService);
        System.out.println("Consumer start...");

        Consumer consumer = new Consumer(demoService);
        consumer.hello();
        consumer.printList();

        consumer.loopInvoke(100);

        System.in.read();
        System.out.println("bye!");
    }

}
