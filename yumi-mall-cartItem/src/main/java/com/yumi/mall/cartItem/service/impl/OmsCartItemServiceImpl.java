package com.yumi.mall.cartItem.service.impl;

import com.yumi.mall.cartItem.service.OmsCartItemService;
import com.yumi.mall.cartItem.service.UmsMemberService;
import com.yumi.mall.mapper.OmsCartItemMapper;
import com.yumi.mall.domain.OmsCartItem;
import com.yumi.mall.domain.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车管理Service实现类
 * Created by yumi on 2019/3/2.
 */
@Service
public class OmsCartItemServiceImpl implements OmsCartItemService {
    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public int add(OmsCartItem cartItem) {
        int count;
        UmsMember currentMember =memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OmsCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null) {
            cartItem.setCreateDate(new Date());
            count = cartItemMapper.insert(cartItem);
        } else {
            cartItem.setModifyDate(new Date());
            existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
            count = cartItemMapper.updateByPrimaryKey(existCartItem);
        }
        return count;
    }

    /**
     * 根据会员id,商品id和规格获取购物车中商品
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {
        Example example = new Example(OmsCartItem.class);
        Example.Criteria criteria = example.createCriteria().andEqualTo("memberId",cartItem.getMemberId())
                .andEqualTo("ProductId",cartItem.getProductId()).andEqualTo("DeleteStatus",0);
        if (!StringUtils.isEmpty(cartItem.getSp1())) {
            criteria.andEqualTo("sp1",cartItem.getSp1());
        }
        if (!StringUtils.isEmpty(cartItem.getSp2())) {
            criteria.andEqualTo("sp2",cartItem.getSp2());
        }
        if (!StringUtils.isEmpty(cartItem.getSp3())) {
            criteria.andEqualTo("sp3",cartItem.getSp3());
        }
        List<OmsCartItem> cartItemList = cartItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(cartItemList)) {
            return cartItemList.get(0);
        }
        return null;
    }

    @Override
    public List<OmsCartItem> list(Long memberId) {
        Example example = new Example(OmsCartItem.class);
        example.createCriteria().andEqualTo("deleteStatus",0).andEqualTo("memberId",memberId);
        return cartItemMapper.selectByExample(example);
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        OmsCartItem cartItem = new OmsCartItem();
        cartItem.setQuantity(quantity);
        Example example = new Example(OmsCartItem.class);
        example.createCriteria().andEqualTo("deleteStatus",0)
                .andEqualTo("id",id).andEqualTo("memberId",memberId);
        return cartItemMapper.updateByExampleSelective(cartItem, example);
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        Example example = new Example(OmsCartItem.class);
        example.createCriteria().andIn("id",ids).andEqualTo("memberId",memberId);
        return cartItemMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        //删除原购物车信息
        OmsCartItem updateCart = new OmsCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(new Date());
        updateCart.setDeleteStatus(1);
        cartItemMapper.updateByPrimaryKeySelective(updateCart);
        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public int clear(Long memberId) {
        OmsCartItem cartItem = new OmsCartItem();
        cartItem.setDeleteStatus(1);
        Example example = new Example(OmsCartItem.class);
        example.createCriteria().andEqualTo("memberId",memberId);
        return cartItemMapper.updateByExampleSelective(cartItem,example);
    }
}
