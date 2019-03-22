package com.yumi.mall.member.service.impl;

import com.yumi.mall.domain.UmsMemberLevel;
import com.yumi.mall.mapper.UmsMemberLevelMapper;
import com.yumi.mall.member.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * Created by yumi on 2019/3/26.
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        Example example = new Example(UmsMemberLevel.class);
        example.createCriteria().andEqualTo("defaultStatus",defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
