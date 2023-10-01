package com.qiang.demomall.productcenter.api.controller;

import com.qiang.demomall.common.request.productcenter.CategotyCreateReq;
import com.qiang.demomall.common.response.MallResponse;
import com.qiang.demomall.productcenter.application.CategoryApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 商品分类控制器
 *
 * @author qiang
 * @date 2023-10-01 22:56:45
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryApplicationService service;

    public MallResponse create(CategotyCreateReq req){

        service.create(req);
        return MallResponse.success();
    }
}
