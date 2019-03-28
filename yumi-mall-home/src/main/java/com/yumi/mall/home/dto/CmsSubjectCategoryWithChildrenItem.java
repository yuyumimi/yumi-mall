package com.yumi.mall.home.dto;

import com.yumi.mall.domain.CmsSubject;
import com.yumi.mall.domain.CmsSubjectCategory;
import com.yumi.mall.domain.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName CmsSubjectCategoryWithChildrenItem
 * @Description TODO
 * @Author yuyu
 * @Date 2019/3/28 10:03
 * @Version 1.0
 **/
@Getter
@Setter
public class CmsSubjectCategoryWithChildrenItem {

    private Long id;

    private String name;

    private Integer type;

    private List<CmsSubjectDto> children;

}
