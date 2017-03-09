package cn.ryanpenn.dubbo.samples.spi.sample.demo;

import cn.ryanpenn.dubbo.samples.spi.sample.api.SpiHelloService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * DemoApp
 */
public class DemoApp {

    public static void main(String[] args) {

        SpiHelloService helloService = null;
        ServiceLoader<SpiHelloService> loader = ServiceLoader.load(SpiHelloService.class);
        Iterator<SpiHelloService> serviceIterator = loader.iterator();
        while (serviceIterator.hasNext()) {
            helloService = serviceIterator.next();
            System.out.println(helloService.sayHello("DemoApp"));
        }

        if (helloService == null) {
            System.out.println("SpiHelloService not found.");
        }
    }
}

