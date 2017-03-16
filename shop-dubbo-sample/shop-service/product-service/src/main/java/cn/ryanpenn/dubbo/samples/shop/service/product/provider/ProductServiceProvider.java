package cn.ryanpenn.dubbo.samples.shop.service.product.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ProductServiceProvider
 */
@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath:dubbo-context.xml")
@ComponentScan(basePackages = {"cn.ryanpenn.dubbo.samples.shop.service.product"})
@MapperScan(basePackages = {"cn.ryanpenn.dubbo.samples.shop.service.product.persist.repository"})
public class ProductServiceProvider {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductServiceProvider.class, args);
        System.out.println("ProductServiceProvider start...");

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
