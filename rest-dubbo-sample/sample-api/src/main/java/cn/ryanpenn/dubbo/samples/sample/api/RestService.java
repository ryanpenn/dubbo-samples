package cn.ryanpenn.dubbo.samples.sample.api;

import java.util.List;

/**
 * RestService
 */
public interface RestService {
    String sayHello(String name);

    List<User> getUsers();

    String dataSizeFormat(long size);
}
