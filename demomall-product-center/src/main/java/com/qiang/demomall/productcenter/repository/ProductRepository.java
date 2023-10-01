package com.qiang.demomall.productcenter.repository;

import com.qiang.demomall.productcenter.repository.dao.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description 商品存储类
 *
 * @author qiang
 * @date 2023-10-01 23:40:10
 */
@Repository
public class ProductRepository {

    @Autowired
    private ProductCategoryDao categoryDao;

    /**
     * 根据类名名称获取类名数量
     * @param categoryName 类名名称
     * @return 类名数量
     */
    public long getCategoryCount(String categoryName) {
        return categoryDao.getCategoryCount(categoryName);
    }
}
