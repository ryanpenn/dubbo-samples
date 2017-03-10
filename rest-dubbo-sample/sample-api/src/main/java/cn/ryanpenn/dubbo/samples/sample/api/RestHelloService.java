package cn.ryanpenn.dubbo.samples.sample.api;

import javax.ws.rs.*;
import java.util.List;

/**
 * RestHelloService
 */
@Path("rest")
@Consumes({"application/json; charset=utf-8"})
@Produces({"application/json; charset=utf-8"})
public interface RestHelloService {

    @GET
    @Path("/hello")
    String sayHello(@QueryParam("name") String name);

    @GET
    @Path("/users")
    List<User> getUsers();

    @POST
    @Path("/format/{size}")
    String dataSizeFormat(@PathParam("size") long size);
}
