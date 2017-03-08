package cn.ryanpenn.dubbo.sample.api;


import java.util.List;

public interface DemoService {

    String sayHello(String name);

    List<User> getUsers();

    String dataSizeFormat(long size);
}
