package cn.ryanpenn.dubbo.samples.sample.consumer;


import cn.ryanpenn.dubbo.samples.sample.api.HelloService;
import cn.ryanpenn.dubbo.samples.sample.api.RestHelloService;
import cn.ryanpenn.dubbo.samples.sample.api.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServiceConsumer {

    static void restInvoke(ApplicationContext context) {
        RestHelloService restHelloService = (RestHelloService) context.getBean("restHelloService");
        System.out.println(restHelloService.sayHello("tom"));

        List<User> list = restHelloService.getUsers();
        list.forEach(System.out::println);

        System.out.println("maxMemory=" + restHelloService.dataSizeFormat(Runtime.getRuntime().maxMemory())
                + ", totalMemory=" + restHelloService.dataSizeFormat(Runtime.getRuntime().totalMemory())
                + ", freeMemory=" + restHelloService.dataSizeFormat(Runtime.getRuntime().freeMemory()));
    }

    static void httpInvoke() throws Exception {
        String url = "http://127.0.0.1:8080/service/";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url + "rest/hello?name=ServiceConsumer");
        HttpResponse response = client.execute(get);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }

        get = new HttpGet(url + "rest/users");
        response = client.execute(get);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }

        HttpPost post = new HttpPost(url + "rest/format/10086");
        response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }

        client.close();
    }

    static void dubboInvoke(ApplicationContext context) {
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.sayHello("tom"));

        List<User> list = helloService.getUsers();
        list.forEach(System.out::println);

        System.out.println("maxMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().maxMemory())
                + ", totalMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().totalMemory())
                + ", freeMemory=" + helloService.dataSizeFormat(Runtime.getRuntime().freeMemory()));
    }

    public static void main(String... args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        context.start();
        System.out.println("ServiceConsumer start...");

        long startTime = System.nanoTime();
        dubboInvoke(context);

        long endTime = System.nanoTime();
        System.out.println(String.format("dubboInvoke 运行时间：%d ms",
                TimeUnit.NANOSECONDS.toMillis((endTime - startTime) / 1000)));

        System.out.println();
        startTime = endTime;
        restInvoke(context);

        endTime = System.nanoTime();
        System.out.println(String.format("restInvoke 运行时间：%d ms",
                TimeUnit.NANOSECONDS.toMillis((endTime - startTime) / 1000)));

        System.out.println();
        startTime = endTime;
        httpInvoke();

        endTime = System.nanoTime();
        System.out.println(String.format("httpInvoke 运行时间：%d ms",
                TimeUnit.NANOSECONDS.toMillis((endTime - startTime) / 1000)));

        System.in.read();
        context.destroy();
        System.exit(0);
    }

}
