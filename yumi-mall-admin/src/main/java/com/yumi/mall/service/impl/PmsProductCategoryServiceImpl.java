package com.yumi.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yumi.mall.dao.PmsProductCategoryDao;
import com.yumi.mall.domain.PmsProduct;
import com.yumi.mall.domain.PmsProductCategory;
import com.yumi.mall.dto.PmsProductCategoryParam;
import com.yumi.mall.dto.PmsProductCategoryWithChildrenItem;
import com.yumi.mall.mapper.PmsProductCategoryMapper;
import com.yumi.mall.mapper.PmsProductMapper;
import com.yumi.mall.service.PmsProductCategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * PmsProductCategoryService实现类
 * Created by yumi on 2019/2/26.
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsProductMapper productMapper;
//    @Autowired
//    private PmsProductCategoryAttributeRelationDao productCategoryAttributeRelationDao;
//    @Autowired
//    private PmsProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;
    @Autowired
    private PmsProductCategoryDao productCategoryDao;
    @Override
    public int create(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = productCategoryMapper.insertSelective(productCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = pmsProductCategoryParam.getProductAttributeIdList();
        if(!CollectionUtils.isEmpty(productAttributeIdList)){
//            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

//    /**
//     * 批量插入商品分类与筛选属性关系表
//     * @param productCategoryId 商品分类id
//     * @param productAttributeIdList 相关商品筛选属性id集合
//     */
//    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
//        List<PmsProductCategoryAttributeRelation> relationList = new ArrayList<>();
//        for (Long productAttrId : productAttributeIdList) {
//            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
//            relation.setProductAttributeId(productAttrId);
//            relation.setProductCategoryId(productCategoryId);
//            relationList.add(relation);
//        }
//        productCategoryAttributeRelationDao.insertList(relationList);
//    }
//
    @Override
    public int update(Long id, PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(productCategory.getName());
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andEqualTo("productCategoryId",id);
        productMapper.updateByExampleSelective(product,example);
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(pmsProductCategoryParam.getProductAttributeIdList())){
//            PmsProductCategoryAttributeRelationExample relationExample = new PmsProductCategoryAttributeRelationExample();
//            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
//            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
//            insertRelationList(id,pmsProductCategoryParam.getProductAttributeIdList());
        }else{
//            PmsProductCategoryAttributeRelationExample relationExample = new PmsProductCategoryAttributeRelationExample();
//            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
//            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
        }
        return productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(PmsProductCategory.class);
        example.setOrderByClause("sort desc");
        example.createCriteria().andEqualTo("parentId",parentId);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        Example example = new Example(PmsProductCategory.class);
        example.createCriteria().andIn("id",ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
       Example example = new Example(PmsProductCategory.class);
        example.createCriteria().andIn("id",ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(PmsProductCategory productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }
}
