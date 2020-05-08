package com.allen.dao;

import com.allen.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAll();
}
