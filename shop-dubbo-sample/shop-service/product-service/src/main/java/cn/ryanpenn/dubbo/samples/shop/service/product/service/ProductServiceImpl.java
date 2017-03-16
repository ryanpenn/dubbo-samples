package cn.ryanpenn.dubbo.samples.shop.service.product.service;

import cn.ryanpenn.dubbo.samples.shop.service.api.product.ProductInfo;
import cn.ryanpenn.dubbo.samples.shop.service.api.product.ProductService;
import cn.ryanpenn.dubbo.samples.shop.service.product.persist.repository.ProductRepository;
//import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ProductServiceImpl
 */
@Component
//@Service(validation = "1.0")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductInfo> list() {
        return null;
    }

    @Override
    public ProductInfo getProductById(int id) {
        return null;
    }

    @Override
    public int sell(List<Integer> ids) {
        return 0;
    }

    @Override
    public int sendBack(List<Integer> ids) {
        return 0;
    }
}
