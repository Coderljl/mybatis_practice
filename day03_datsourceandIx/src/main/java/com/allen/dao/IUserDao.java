package com.allen.dao;

import com.allen.domain.QueryVo;
import com.allen.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserDao {
    /**
     * 用户接口
     */
//    查询所有用户
    List<User> findAll();


// 根据id查找用户
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据传入参数条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo查询用户信息
     * @param queryVo
     * @return
     */
    List<User> findUserInids(QueryVo queryVo);
}
