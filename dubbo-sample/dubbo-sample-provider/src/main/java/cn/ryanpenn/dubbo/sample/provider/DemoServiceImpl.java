package cn.ryanpenn.dubbo.sample.provider;


import cn.ryanpenn.dubbo.sample.api.DemoService;
import cn.ryanpenn.dubbo.sample.api.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("sayHello(" + name + ")");
        return "Hello " + name;
    }

    @Override
    public List<User> getUsers() {
        System.out.println("getUsers()");

        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setName("jack");
        u1.setAge(20);

        User u2 = new User();
        u2.setName("tom");
        u2.setAge(21);

        User u3 = new User();
        u3.setName("rose");
        u3.setAge(19);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }

    @Override
    public String dataSizeFormat(long size) {
        DecimalFormat formater = new DecimalFormat("####.00");
        if (size < 1024L) {
            return size + "bytes";
        } else if (size < 1024L * 1024L) {
            float kbsize = size / 1024F;
            return formater.format(kbsize) + "KB";
        } else if (size < 1024L * 1024L * 1024L) {
            float mbsize = size / 1024F / 1024F;
            return formater.format(mbsize) + "MB";
        } else if (size < 1024L * 1024L * 1024L * 1024L) {
            float gbsize = size / 1024F / 1024F / 1024F;
            return formater.format(gbsize) + "GB";
        } else if (size < 1024L * 1024L * 1024L * 1024L * 1024L) {
            float tbsize = size / 1024F / 1024F / 1024F / 1024F;
            return formater.format(tbsize) + "TB";
        } else {
            return "size: error";
        }
    }
}
