package cn.ryanpenn.dubbo.samples.shop.service.product.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ProductServiceProvider
 */
@SpringBootApplication
//@EnableTransactionManagement
//@ImportResource("classpath:dubbo-context.xml")
//@MapperScan(basePackages = {"cn.ryanpenn.dubbo.samples.shop.service.product.persist.repository"})
public class ProductServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductServiceApplication.class, args);
        System.out.println("ProductServiceProvider start...");

        System.in.read();
        System.out.println("bye");
        System.exit(0);
    }

}
