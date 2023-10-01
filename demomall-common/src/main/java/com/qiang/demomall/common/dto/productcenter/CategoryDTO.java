package com.qiang.demomall.common.dto.productcenter;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description 商品类目信息
 *
 * @author qiang
 * @date 2023-10-01 23:24:43
 */
@Data
public class CategoryDTO {
    /**
     * 商品类目id
     */
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
