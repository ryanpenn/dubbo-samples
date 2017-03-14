package cn.ryanpenn.dubbo.samples.shop.service.api.product;

import java.util.List;

/**
 * ProductService
 */
public interface ProductService {

    /**
     * 产品列表
     *
     * @return
     */
    List<ProductInfo> list();

    /**
     * 获取产品信息
     *
     * @param id 商品Id
     * @return
     */
    ProductInfo getProductById(int id);

    /**
     * 售出
     *
     * @param ids 商品Id列表
     * @return
     */
    int sell(List<Integer> ids);

    /**
     * 退回
     *
     * @param ids 商品Id列表
     * @return
     */
    int sendBack(List<Integer> ids);
}
