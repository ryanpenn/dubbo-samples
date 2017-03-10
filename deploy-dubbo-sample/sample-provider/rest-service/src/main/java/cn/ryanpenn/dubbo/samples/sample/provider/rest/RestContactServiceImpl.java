package cn.ryanpenn.dubbo.samples.sample.provider.rest;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import cn.ryanpenn.dubbo.samples.sample.api.rest.RestContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * RestContactServiceImpl
 */
public class RestContactServiceImpl implements RestContactService {

    @Autowired
    ContactService contactService;

    @Override
    public String info() {
        return "rest-service implements RestContactService";
    }

    @Override
    public void save(Contact contact) {
        contactService.save(contact);
    }

    @Override
    public List<Contact> list() {
        return contactService.list();
    }

    @Override
    public List<Contact> searchByName(String name) {
        return contactService.searchByName(name);
    }

    @Override
    public Contact getById(int id) {
        return contactService.getById(id);
    }

    @Override
    public void delete(int id) {
        contactService.delete(id);
    }
}
