package com.yumi.mall.dto;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by yumi on 2019/2/26.
 */
public class PmsProductResult extends PmsProductParam {
    //商品所选分类的父id
    private Long cateParentId;

    public Long getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(Long cateParentId) {
        this.cateParentId = cateParentId;
    }
}
