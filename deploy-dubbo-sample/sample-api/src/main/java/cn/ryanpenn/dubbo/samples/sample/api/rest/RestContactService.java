package cn.ryanpenn.dubbo.samples.sample.api.rest;

import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.*;
import java.util.List;

/**
 * RestContactService
 */
@Path("contact")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public interface RestContactService {

    @GET
    @Path("info")
    String info();

    @POST
    @Path("save")
    void save(Contact contact);

    @GET
    @Path("list")
    List<Contact> list();

    @GET
    @Path("search/{name}")
    List<Contact> searchByName(@PathParam("name") String name);

    @GET
    @Path("{id : \\+d}")
    Contact getById(@PathParam("id") int id);

    @POST
    @Path("del")
    void delete(@QueryParam("id") int id);
}
