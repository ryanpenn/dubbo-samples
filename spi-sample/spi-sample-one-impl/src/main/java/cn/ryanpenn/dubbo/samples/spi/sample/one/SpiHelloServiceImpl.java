package cn.ryanpenn.dubbo.samples.spi.sample.one;

import cn.ryanpenn.dubbo.samples.spi.sample.api.SpiHelloService;

/**
 * SpiHelloServiceImpl
 */
public class SpiHelloServiceImpl implements SpiHelloService {
    public String sayHello(String name) {
        return "one SpiHelloServiceImpl say: Hello " + name;
    }
}
