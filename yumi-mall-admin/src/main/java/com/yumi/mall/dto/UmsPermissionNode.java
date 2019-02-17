package com.yumi.mall.dto;

import com.yumi.mall.domain.UmsPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UmsPermissionNode extends UmsPermission {
    @Getter
    @Setter
    private List<UmsPermissionNode> children;
}
