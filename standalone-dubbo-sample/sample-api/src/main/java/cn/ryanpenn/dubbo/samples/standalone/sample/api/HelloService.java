package cn.ryanpenn.dubbo.samples.standalone.sample.api;

/**
 * HelloService
 */
public interface HelloService {

    String sayHello(String name);

    User register(String name, int age);
}
