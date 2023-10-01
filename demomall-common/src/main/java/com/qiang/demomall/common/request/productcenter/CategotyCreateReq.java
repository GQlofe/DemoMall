package com.qiang.demomall.common.request.productcenter;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @description 创建商品类目请求对象
 *
 * @author qiang
 * @date 2023-10-01 23:04:10
 */
@Data
public class CategotyCreateReq {

    /**
     * 类目名称
     */
    @NotBlank(message = "类目名称不能为空")
    private String categoryName;

    /**
     * 父类目id
     */
    private Long parentId;

    /**
     * 排序字段，0排最前
     */
    private Integer sort;

    /**
     * 状态：1生效中，2未生效
     */
    private Integer status;
}
