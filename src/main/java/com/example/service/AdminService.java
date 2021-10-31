package com.example.service;

import com.example.pojo.Admin;

/**
 * @author: ming
 * @date: 2021/10/26 20:16
 */
public interface AdminService {

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    Admin login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    Admin getUserDetailById(Long userId);

    /**
     * 更新密码
     * @param userId
     * @param orginalPassword
     * @param newPassword
     * @return
     */
    boolean updatePassword(Long userId, String orginalPassword, String newPassword);

    /**
     * 修改登录名称
     * @param userId
     * @param loginUserName
     * @param nickName
     * @return
     */
    boolean updateName(Long userId,String loginUserName, String nickName);
}
