package com.example.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author: ming
 * @date: 2021/10/23 17:09
 */

@Getter
@Setter
@ToString
@Component
public class Admin {
    /**
     * 管理员主键id
     */
    private Long adminId;
    /**
     * 管理员登录名称
     */
    private String loginName;
    /**
     * 管理员登录密码
     */
    private String loginPassword;
    /**
     * 管理员显示名称
     */
    private String adminNickName;
    /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
    private Byte locked;

    public void setLoginName(String loginName) {
        if (loginName != null) {
            this.loginName = loginName.trim();
        } else {
            this.loginName = null;
        }
    }

    public void setLoginPassword(String loginPassword) {
        if (loginPassword != null) {
            this.loginPassword = loginPassword.trim();
        } else {
            this.loginPassword = null;
        }
    }

    public void setAdminNickName(String adminNickName) {
        if (adminNickName != null) {
            this.adminNickName = adminNickName.trim();
        } else {
            this.adminNickName = null;
        }
    }


}
