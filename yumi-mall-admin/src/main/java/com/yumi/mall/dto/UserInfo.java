package com.yumi.mall.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登陆后信息
 */
@Getter
@Setter
public class UserInfo {
    private Long id;
    private String username;
    private Integer phone;
    private String icon;
    private String email;
    private String nickName;
    private String note;

    private String password;
    private String newpassword1;
    private String newpassword2;

}
