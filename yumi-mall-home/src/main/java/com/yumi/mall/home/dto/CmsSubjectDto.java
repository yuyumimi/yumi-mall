package com.yumi.mall.home.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName CmsSubjectDto
 * @Description TODO
 * @Author yuyu
 * @Date 2019/3/28 11:00
 * @Version 1.0
 **/
@Getter
@Setter
public class CmsSubjectDto implements Serializable {
    private Long id;

    private String title;

    /**
     * 专题主图
     */
    private String picUrl;

    private String productId;
}
