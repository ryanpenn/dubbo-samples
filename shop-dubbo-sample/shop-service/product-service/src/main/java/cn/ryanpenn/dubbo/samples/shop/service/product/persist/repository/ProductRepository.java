package cn.ryanpenn.dubbo.samples.shop.service.product.persist.repository;

import cn.ryanpenn.dubbo.samples.shop.service.product.extend.MyMapper;
import cn.ryanpenn.dubbo.samples.shop.service.product.persist.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends MyMapper<ProductEntity> {

    List<ProductEntity> searchByName(String name);

}
