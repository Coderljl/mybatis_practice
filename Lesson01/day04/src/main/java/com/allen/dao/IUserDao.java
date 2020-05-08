package com.allen.dao;

import com.allen.domain.User;

import java.util.List;

public interface IUserDao {
    /**查询所有用户
     * 用户接口
     */
    List<User> findAll();
//   保存用户


// 根据id查找用户
    User findById(Integer userId);

}
