package com.example.dao;

import com.example.pojo.Admin;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: ming
 * @date: 2021/10/23 17:08
 */
@Repository
public interface AdminMapper {
    Admin selectByPrimaryKey(Long adminId);

    Admin login(@Param("userName") String userName, @Param("password") String password);

    int deleteByPrimaryKey(Long adminId);

    int insert(Admin admin);

    int insertSelective(Admin admin);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);

}
