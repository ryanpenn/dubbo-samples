package cn.ryanpenn.dubbo.samples.sample.api.dubbo;

import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;

import java.util.List;

/**
 * ContactService
 */
public interface ContactService {

    String info();

    void save(Contact contact);

    List<Contact> list();

    List<Contact> searchByName(String name);

    Contact getById(int id);

    void delete(int id);
}
