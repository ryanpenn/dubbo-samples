package cn.ryanpenn.dubbo.samples.shop.service.api.product;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductService的本地存根
 * - 代理ProductService，自动构建
 *
 * @Ref Dubbo用户手册 http://dubbo.io/User+Guide-zh.htm
 */
public class ProductServiceStub implements ProductService {

    private final ProductService productService;

    public ProductServiceStub(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductInfo> list() {
        try {
            System.out.println("ProductServiceStub.list()");
            return productService.list();
        } catch (Exception e) {
            // 处理错误
            e.printStackTrace();
        }

        // 返回容错数据
        return new ArrayList<>();
    }

    @Override
    public ProductInfo getProductById(int id) {
        return productService.getProductById(id);
    }

    @Override
    public int sell(List<Integer> ids) {
        return productService.sell(ids);
    }

    @Override
    public int sendBack(List<Integer> ids) {
        return productService.sendBack(ids);
    }
}
