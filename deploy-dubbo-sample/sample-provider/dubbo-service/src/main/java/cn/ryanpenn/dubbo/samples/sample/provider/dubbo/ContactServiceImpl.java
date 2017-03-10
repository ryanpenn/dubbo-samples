package cn.ryanpenn.dubbo.samples.sample.provider.dubbo;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ContactServiceImpl
 */
public class ContactServiceImpl implements ContactService {

    private static int idGen = 0;
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public String info() {
        return "dubbo-service implements ContactService";
    }

    @Override
    public void save(Contact contact) {
        idGen++;
        contact.setId(idGen);
        contacts.add(contact);
    }

    @Override
    public List<Contact> list() {
        return contacts;
    }

    @Override
    public List<Contact> searchByName(String name) {
        return contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public Contact getById(int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        Contact contact = getById(id);
        if (contact != null)
            contacts.remove(contact);
    }
}
