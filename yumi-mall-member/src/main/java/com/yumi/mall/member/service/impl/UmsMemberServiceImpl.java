package com.yumi.mall.member.service.impl;

import com.yumi.mall.mapper.UmsMemberLevelMapper;
import com.yumi.mall.mapper.UmsMemberMapper;
import com.yumi.mall.domain.UmsMember;
import com.yumi.mall.domain.UmsMemberLevel;
import com.yumi.mall.member.dto.CommonResult;
import com.yumi.mall.member.dto.MemberDetails;
import com.yumi.mall.member.service.RedisService;
import com.yumi.mall.member.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 会员管理Service实现类
 * Created by yumi on 2019/3/19.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private RedisService redisService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${authCode.expire.seconds}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

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
    public CommonResult register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            return new CommonResult().failed("验证码错误");
        }
        //查询是否已有该用户
        Example example = new Example(UmsMember.class);
        example.createCriteria().andEqualTo("username", username);
        example.or(example.createCriteria().andEqualTo("phone", telephone));
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            return new CommonResult().failed("该用户已经存在");
        }
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //获取默认会员等级并设置
        Example levelExample = new Example(UmsMemberLevel.class);
        levelExample.createCriteria().andEqualTo("defaultStatus", 1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
        return new CommonResult().success("注册成功", null);
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString(), AUTH_CODE_EXPIRE_SECONDS, TimeUnit.SECONDS);
//        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
//        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return new CommonResult().success("获取验证码成功", sb.toString());
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        Example example = new Example(UmsMember.class);
        example.createCriteria().andEqualTo("phone", telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(memberList)) {
            return new CommonResult().failed("该账号不存在");
        }
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            return new CommonResult().failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return new CommonResult().success("密码修改成功", null);
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record = new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }

        String realAuthCode = redisTemplate.opsForValue().get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return authCode.equals(realAuthCode);
    }

}
