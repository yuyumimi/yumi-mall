package com.yumi.mall.cartItem.service.impl;

import com.yumi.mall.cartItem.service.UmsMemberService;
import com.yumi.mall.domain.UmsMember;
import com.yumi.mall.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 会员管理Service实现类
 * Created by yumi on 2019/3/19.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;


    @Override
    public UmsMember getByUsername(String username) {
        Example example = new Example(UmsMember.class);
        example.createCriteria().andEqualTo("username", username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }


    @Override
    public UmsMember getCurrentMember() {
        return null;
    }



}
