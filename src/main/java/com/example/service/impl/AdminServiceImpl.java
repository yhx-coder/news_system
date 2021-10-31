package com.example.service.impl;

import com.example.dao.AdminMapper;
import com.example.pojo.Admin;
import com.example.service.AdminService;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ming
 * @date: 2021/10/26 20:17
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String userName, String password) {
        String encodePassword = MD5Util.MD5Encode(password, "UTF-8");
        return adminMapper.login(userName, encodePassword);
    }

    @Override
    public Admin getUserDetailById(Long userId) {
        return adminMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean updatePassword(Long userId, String orginalPassword, String newPassword) {

        Admin admin = adminMapper.selectByPrimaryKey(userId);
        if (admin != null) {
            String encodeOrginalPassword = MD5Util.MD5Encode(orginalPassword, "UTF-8");
            if (admin.getLoginPassword().equals(encodeOrginalPassword)) {
                String encodeNewPassword = MD5Util.MD5Encode(newPassword, "UTF-8");
                Admin adminNew = new Admin();
                adminNew.setAdminId(userId);
                adminNew.setLoginPassword(encodeNewPassword);
                return adminMapper.updateByPrimaryKeySelective(adminNew) > 0;
            }
        }
        return false;
    }

    @Override
    public boolean updateName(Long userId, String loginUserName, String nickName) {
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        if (admin != null) {
            Admin adminNew = new Admin();
            adminNew.setAdminId(userId);
            adminNew.setLoginName(loginUserName);
            adminNew.setAdminNickName(nickName);
            return adminMapper.updateByPrimaryKeySelective(adminNew) > 0;
        }
        return false;
    }
}
