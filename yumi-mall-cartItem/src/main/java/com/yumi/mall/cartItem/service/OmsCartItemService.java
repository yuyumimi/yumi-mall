package com.yumi.mall.cartItem.service;

import com.yumi.mall.domain.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车管理Service
 * Created by yumi on 2019/3/2.
 */
public interface OmsCartItemService {
    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * 根据会员编号获取购物车列表
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * 修改某个购物车商品的数量
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * 批量删除购物车中的商品
     */
    int delete(Long memberId, List<Long> ids);

    /**
     * 修改购物车中商品的规格
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * 清空购物车
     */
    int clear(Long memberId);
}
