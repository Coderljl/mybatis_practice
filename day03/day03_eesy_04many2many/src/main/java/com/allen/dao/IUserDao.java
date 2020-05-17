package com.allen.dao;

import com.allen.domain.User;

import java.util.List;

public interface  IUserDao {
    /**
     * 用户接口
     */
//    查询所有用户
    List<User> findAll();

// 根据id查找用户
    User findById(Integer userId);


}
