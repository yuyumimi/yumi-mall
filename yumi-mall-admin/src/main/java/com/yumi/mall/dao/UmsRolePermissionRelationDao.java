package com.yumi.mall.dao;

import com.yumi.mall.domain.UmsPermission;
import com.yumi.mall.domain.UmsRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 后台用户角色管理自定义Dao
 */
public interface UmsRolePermissionRelationDao {
    /**
     * 批量插入角色和权限关系
     */
    int insertList(@Param("list") List<UmsRolePermissionRelation> list);

    /**
     * 根据角色获取权限
     */
    List<UmsPermission> getPermissionList(@Param("roleId") Long roleId);
}
