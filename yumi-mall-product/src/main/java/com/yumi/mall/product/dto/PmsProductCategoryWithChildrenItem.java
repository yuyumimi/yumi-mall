package com.yumi.mall.product.dto;


import com.yumi.mall.domain.PmsProductCategory;

import java.util.List;

/**
 * Created by yumi on 2019/2/25.
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}
