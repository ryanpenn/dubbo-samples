package cn.ryanpenn.dubbo.samples.sample.provider.mixed;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.mixed.MixedContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * MixedContactServiceImpl
 */
public class MixedContactServiceImpl implements MixedContactService {

    @Autowired
    ContactService contactService;

    @Override
    public String info() {
        return "mixed-service implements MixedContactService";
    }

    @Override
    public void save(Contact contact) {
        contactService.save(contact);
    }

    @Override
    public void delete(int id) {
        contactService.delete(id);
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
}
