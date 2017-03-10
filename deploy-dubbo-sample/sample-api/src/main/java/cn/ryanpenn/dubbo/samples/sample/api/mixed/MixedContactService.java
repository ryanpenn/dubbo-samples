package cn.ryanpenn.dubbo.samples.sample.api.mixed;

import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;

import javax.ws.rs.*;
import java.util.List;

/**
 * MixedContactService
 * - rest协议只读
 * - dubbo协议可读写
 */
@Path("read-only")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public interface MixedContactService {

    @GET
    @Path("info")
    String info();

    void save(Contact contact);

    void delete(@QueryParam("id") int id);

    @GET
    @Path("list")
    List<Contact> list();

    @GET
    @Path("search/{name}")
    List<Contact> searchByName(@PathParam("name") String name);

    @GET
    @Path("{id : \\+d}")
    Contact getById(@PathParam("id") int id);
}
