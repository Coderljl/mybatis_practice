package com.allen.dao;

import com.allen.domain.QueryVo;
import com.allen.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface  IUserDao {
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



    List<User>  findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件有可能有用户名，有性别，也有可能有地址，还可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     *根据queryvo中的ID，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserByInIds(QueryVo vo);
}
