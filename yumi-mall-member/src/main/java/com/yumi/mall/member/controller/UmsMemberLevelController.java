package com.yumi.mall.member.controller;

import com.yumi.mall.domain.UmsMemberLevel;
import com.yumi.mall.member.dto.CommonResult;
import com.yumi.mall.member.service.UmsMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 会员等级管理Controller
 * Created by yumi on 2019/3/26.
 */
@Controller
@Api(tags = "UmsMemberLevelController",description = "会员等级管理")
@RequestMapping("/member/level")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService memberLevelService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查询所有会员等级")
    @ResponseBody
    public Object list(@RequestParam("defaultStatus") Integer defaultStatus){
        List<UmsMemberLevel> memberLevelList = memberLevelService.list(defaultStatus);
        return new CommonResult().success(memberLevelList);
    }
}
