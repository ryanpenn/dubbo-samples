package cn.ryanpenn.dubbo.samples.sample.provider.restweb;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import cn.ryanpenn.dubbo.samples.sample.api.rest.RestContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * WebRestContactServiceImpl
 */
public class WebRestContactServiceImpl implements RestContactService {

    @Autowired
    ContactService contactService;

    @Override
    public String info(){
        return "rest-service-web implements RestContactService";
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
