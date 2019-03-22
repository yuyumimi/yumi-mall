package com.yumi.mall.member.service;


import com.yumi.mall.domain.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service
 * Created by yumi on 2019/3/26.
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
