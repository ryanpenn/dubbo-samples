package cn.ryanpenn.dubbo.samples.sample.consumer.dubbo;

import cn.ryanpenn.dubbo.samples.sample.api.dubbo.ContactService;
import cn.ryanpenn.dubbo.samples.sample.api.mixed.MixedContactService;
import cn.ryanpenn.dubbo.samples.sample.api.model.Address;
import cn.ryanpenn.dubbo.samples.sample.api.model.Contact;
import cn.ryanpenn.dubbo.samples.sample.api.rest.RestContactService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * ServiceConsumer
 * DUBBO使用问题记录: https://my.oschina.net/greki/blog/550976
 */
public class ServiceConsumer {

    private Contact newContact(String name, String phone, String email){
        return Contact.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .address(Address.builder()
                        .country("china")
                        .province("广东")
                        .city("广州")
                        .street("中山路")
                        .zipCode(123)
                        .build())
                .memo("add from dubbo-client.")
                .build();
    }


    public void testDubbo(ApplicationContext context) throws ExecutionException, InterruptedException {
        ContactService contactService = (ContactService) context.getBean("contactService");
        if (contactService != null) {
            contactService.list(); // async
            Future<List<Contact>> pFuture = RpcContext.getContext().getFuture();
            System.out.println("异步调用ContactService.list()");

            System.out.println(contactService.info()); // sync

            System.out.println("add new Contact...in dubbo");
            Contact contact = newContact("tom","123456","tom@test.com");
            contactService.save(contact);

            // call 10 times
            for (int i = 0; i < 10; i++) {
                System.out.println("dubbo " + i + " - " + contactService.info());
            }

            System.out.println("异步调用list结果:");
            List<Contact> contacts = pFuture.get();
            contacts.forEach(System.out::println);
        } else {
            System.out.println("ContactService is null.");
        }

        System.out.println();
    }

    public void testRest(ApplicationContext context) {
        RestContactService restContactService = (RestContactService) context.getBean("restContactService");
        if (restContactService != null) {
            System.out.println("list count: " + restContactService.list().size());

            System.out.println("add new Contact...in rest");
            Contact contact = newContact("cool","666","666@test.com");
            restContactService.save(contact);

            // call 10 times
            for (int i = 0; i < 10; i++) {
                System.out.println("rest" + i + " - " + restContactService.info());
            }

            System.out.println("list count: " + restContactService.list().size());
        } else {
            System.out.println("RestContactService is null.");
        }

        System.out.println();
    }

    public void testMixed_dubbo(ApplicationContext context) {
        MixedContactService mixedContactService = (MixedContactService) context.getBean("mixedContactService_dubbo");
        if (mixedContactService != null) {
            System.out.println(mixedContactService.info());
            System.out.println("list count: " + mixedContactService.list().size());

            System.out.println("add new Contact...in dubbo");
            Contact contact = newContact("jay","555555","jay@test.com");
            mixedContactService.save(contact);

            System.out.println("list count: " + mixedContactService.list().size());
        } else {
            System.out.println("MixedContactService(dubbo) is null.");
        }

        System.out.println();
    }

    public void testMixed_rest(ApplicationContext context) {
        MixedContactService mixedContactService = (MixedContactService) context.getBean("mixedContactService_rest");
        if (mixedContactService != null) {
            System.out.println(mixedContactService.info());
            System.out.println("list count: " + mixedContactService.list().size());

            System.out.println("add new Contact...in rest");
            Contact contact = newContact("rest","222222","rest@test.com");
            mixedContactService.save(contact);

            System.out.println("list count: " + mixedContactService.list().size());
        } else {
            System.out.println("MixedContactService(rest) is null.");
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("dubbo ServiceConsumer start...");

        ServiceConsumer consumer = new ServiceConsumer();
        System.out.println("consumer.testDubbo()");
        consumer.testDubbo(context);

        System.out.println("consumer.testRest()");
        consumer.testRest(context);

        System.out.println("consumer.testMixed_dubbo()");
        consumer.testMixed_dubbo(context);

        System.out.println("consumer.testMixed_rest()");
        consumer.testMixed_rest(context);

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
