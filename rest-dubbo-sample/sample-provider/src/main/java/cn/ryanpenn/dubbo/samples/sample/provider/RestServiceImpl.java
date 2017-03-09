package cn.ryanpenn.dubbo.samples.sample.provider;

import cn.ryanpenn.dubbo.samples.sample.api.RestService;
import cn.ryanpenn.dubbo.samples.sample.api.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("rest")
public class RestServiceImpl implements RestService {

    @GET
    @Path("hello/{name}")
    @Produces("application/json; charset=utf-8")
    @Override
    public String sayHello(@PathParam("name") String name) {
        System.out.println("sayHello(" + name + ")");
        return "Hello " + name;
    }

    @GET
    @Path("users")
    @Produces("application/json; charset=utf-8")
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

    @GET
    @Path("format/{size}")
    @Produces("application/json; charset=utf-8")
    @Override
    public String dataSizeFormat(@PathParam("size") long size) {
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
