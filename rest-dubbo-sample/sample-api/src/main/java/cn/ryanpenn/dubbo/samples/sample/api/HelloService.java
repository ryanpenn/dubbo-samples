package cn.ryanpenn.dubbo.samples.sample.api;

import java.util.List;

/**
 * HelloService
 */
public interface HelloService {
    String sayHello(String name);

    List<User> getUsers();

    String dataSizeFormat(long size);
}
