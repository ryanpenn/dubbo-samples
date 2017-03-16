package cn.ryanpenn.dubbo.samples.shop.service.order.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * OrderServiceProvider
 */
@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath:dubbo-context.xml")
@ComponentScan("cn.ryanpenn.dubbo.samples.shop.service.order")
@MapperScan("cn.ryanpenn.dubbo.samples.shop.service.order.persist.repository")
public class OrderServiceProvider {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OrderServiceProvider.class, args);
        System.out.println("OrderServiceProvider start...");

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
