package com.yumi.mall.home.dao;

import com.yumi.mall.domain.CmsSubjectCategory;
import com.yumi.mall.home.dto.CmsSubjectCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CmsSubjectDao
 * @Description TODO
 * @Author yuyu
 * @Date 2019/3/28 10:11
 * @Version 1.0
 **/
public interface CmsSubjectCategoryDao {

    public List<CmsSubjectCategoryWithChildrenItem> listWithChildren(@Param("position") Integer position);
}
