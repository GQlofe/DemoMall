package com.qiang.demomall.productcenter.domain.category.impl;

import com.qiang.demomall.common.dto.productcenter.CategoryDTO;
import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.enums.YesNoEnum;
import com.qiang.demomall.common.enums.productcenter.CategoryLevelEnum;
import com.qiang.demomall.common.exceptions.MallException;
import com.qiang.demomall.productcenter.domain.category.CategoryService;
import com.qiang.demomall.productcenter.repository.ProductRepository;
import com.qiang.demomall.productcenter.repository.dao.ProductCategoryDao;
import com.qiang.demomall.productcenter.repository.entity.ProductCategoryDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 商品类目服务实现类
 *
 * @author qiang
 * @date 2023-10-01 23:21:56
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryDao categoryDao;

    @Override
    public void create(CategoryDTO dto) {

        // 校验类目名称是否已存在
        checkCategoryName(dto.getCategoryName());


        ProductCategoryDO categoryDO = new ProductCategoryDO();
        categoryDO.setCategoryName(dto.getCategoryName());

        setLevelAndLeaf(dto, categoryDO);

        categoryDO.setSort(dto.getSort());

        categoryDO.setStatus(dto.getStatus());

        categoryDO.setIsDelete(YesNoEnum.NO.getCode());

        categoryDao.save(categoryDO);

    }


    /**
     * 校验商品类目名称
     * @param name 类目名称
     */
    private void checkCategoryName(String name) {
        long count = productRepository.getCategoryCount(name);
        if (count > 0) {
            throw new MallException(ErrorCodeEnum.ERROR_3000);
        }
    }

    /**
     * 设置级别 和 叶子
     * @param dto dto
     * @param categoryDO categoryDO
     */
    private void setLevelAndLeaf(CategoryDTO dto, ProductCategoryDO categoryDO) {
        Long parentId = dto.getParentId();
        if (parentId == null) {
            categoryDO.setLevel(CategoryLevelEnum.FIRST.getCode());
            categoryDO.setLeaf(YesNoEnum.NO.getCode());
        } else {
            ProductCategoryDO parent = categoryDao.getById(parentId);
            if (parent == null) {
                log.error("不存在父级商品类目 parentId={}", parentId);
                throw new MallException(ErrorCodeEnum.ERROR_3001);
            }

            categoryDO.setParentId(parentId);

            // 若父级类目是一级，则当前类目是二级；否则是三级
            if (CategoryLevelEnum.FIRST.getCode() == parent.getLevel()) {
                categoryDO.setLevel(CategoryLevelEnum.SECOND.getCode());
                categoryDO.setLeaf(YesNoEnum.NO.getCode());
            } else {
                categoryDO.setLevel(CategoryLevelEnum.THIRD.getCode());
                categoryDO.setLeaf(YesNoEnum.YES.getCode());
            }
        }
    }
}
