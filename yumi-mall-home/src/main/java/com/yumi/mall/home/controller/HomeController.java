package com.yumi.mall.home.controller;

import com.yumi.mall.domain.CmsSubject;
import com.yumi.mall.domain.PmsProduct;
import com.yumi.mall.domain.PmsProductCategory;
import com.yumi.mall.home.dto.HomeContentResult;
import com.yumi.mall.home.service.HomeService;
import com.yumi.mall.order.dto.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页内容管理Controller
 * Created by macro on 2019/1/28.
 */
@Controller
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public Object content() {
        HomeContentResult contentResult = homeService.content();
        return new CommonResult().success(contentResult);
    }

    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @ResponseBody
    public Object recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return new CommonResult().success(productList);
    }

    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return new CommonResult().success(productCategoryList);
    }

    @ApiOperation("根据分类获取专题")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    @ResponseBody
    public Object getSubjectList(@RequestParam(required = false) Long cateId,
                                 @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId,pageSize,pageNum);
        return new CommonResult().success(subjectList);
    }
}
