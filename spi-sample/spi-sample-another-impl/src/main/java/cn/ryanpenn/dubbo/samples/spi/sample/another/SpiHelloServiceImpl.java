package cn.ryanpenn.dubbo.samples.spi.sample.another;

import cn.ryanpenn.dubbo.samples.spi.sample.api.SpiHelloService;

/**
 * SpiHelloServiceImpl
 */
public class SpiHelloServiceImpl implements SpiHelloService {
    public String sayHello(String name) {
        return "another SpiHelloServiceImpl say: Hello " + name;
    }
}
