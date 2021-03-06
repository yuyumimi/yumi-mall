package com.yumi.mall.cartItem.service;

import com.yumi.mall.domain.UmsMember;

/**
 * 会员管理Service
 * Created by yumi on 2019/3/19.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();


}
