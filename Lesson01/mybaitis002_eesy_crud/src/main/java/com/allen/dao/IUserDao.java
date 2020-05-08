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
//   保存用户

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
//更新用户
    void updateUser(User user);
//  根据id删除用户
     void deleteUser(Integer userId);
// 根据id查找用户
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     * @return
     */
    int total();

    List<User>  findUserByVo(QueryVo vo);
}
