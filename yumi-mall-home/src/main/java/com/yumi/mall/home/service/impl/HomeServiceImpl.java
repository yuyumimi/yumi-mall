package com.yumi.mall.home.service.impl;

import com.github.pagehelper.PageHelper;
import com.yumi.mall.domain.CmsSubject;
import com.yumi.mall.domain.PmsProduct;
import com.yumi.mall.domain.PmsProductCategory;
import com.yumi.mall.domain.SmsHomeAdvertise;
import com.yumi.mall.home.dao.HomeDao;
import com.yumi.mall.home.dto.HomeContentResult;
import com.yumi.mall.home.service.HomeService;
import com.yumi.mall.mapper.CmsSubjectMapper;
import com.yumi.mall.mapper.PmsProductCategoryMapper;
import com.yumi.mall.mapper.PmsProductMapper;
import com.yumi.mall.mapper.SmsHomeAdvertiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 首页内容管理Service实现类
 * Created by macro on 2019/1/28.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
//        result.setBrandList(homeDao.getRecommendBrandList(0,4));
        //获取秒杀信息
//        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
//        result.setNewProductList(homeDao.getNewProductList(0,4));
        //获取人气推荐
//        result.setHotProductList(homeDao.getHotProductList(0,4));
        //获取推荐专题
//        result.setSubjectList(homeDao.getRecommendSubjectList(0,4));
        return result;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        // TODO: 2019/1/29 暂时默认推荐所有商品
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(PmsProduct.class);
        example.createCriteria()
                .andEqualTo("deleteStatus",0)
                .andEqualTo("publishStatus",1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        Example example = new Example(PmsProductCategory.class);
        example.createCriteria()
                .andEqualTo("showStatus",1)
                .andEqualTo("parentId",parentId);
        example.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(CmsSubject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showStatus",1);
        if(cateId!=null){
            criteria.andEqualTo("categoryId",cateId);
        }
        return subjectMapper.selectByExample(example);
    }


    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        Example example = new Example(SmsHomeAdvertise.class);
        example.createCriteria().andEqualTo("type",1).andEqualTo("status",1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }
}
