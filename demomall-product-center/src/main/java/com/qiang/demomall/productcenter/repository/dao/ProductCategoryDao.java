package com.qiang.demomall.productcenter.repository.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiang.demomall.productcenter.repository.entity.ProductCategoryDO;
import com.qiang.demomall.productcenter.repository.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品类目表 服务实现类
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Repository
public class ProductCategoryDao extends ServiceImpl<ProductCategoryMapper, ProductCategoryDO> {

    /**
     * 根据类名名称获取类名数量
     * @param categoryName 类名名称
     * @return 类名数量
     */
    public long getCategoryCount(String categoryName) {
        LambdaQueryWrapper<ProductCategoryDO> query = new LambdaQueryWrapper<>();
        query.eq(ProductCategoryDO::getCategoryName, categoryName);
        return this.count(query);

    }
}
