package com.qiang.demomall.productcenter.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品类目表
 * </p>
 *
 * @author qiang
 * @since 2023-09-14
 */
@Getter
@Setter
@TableName("tb_product_category")
public class ProductCategoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品类目id
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 父类目id
     */
    private Long parentId;

    /**
     * 是否叶子节点：0否，1是
     */
    private Integer leaf;

    /**
     * 类目层级
     */
    private Integer level;

    /**
     * 完整路径，下划线隔开
     */
    private String path;

    /**
     * 排序字段，0排最前
     */
    private Integer sort;

    /**
     * 状态：1生效中，2未生效
     */
    private Integer status;

    /**
     * 是否删除：0否，1是
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
