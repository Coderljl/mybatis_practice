package com.allen;

import com.allen.dao.IUserDao;
//import com.allen.domain.QueryVo;
import com.allen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory factory;

    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1. 读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
         factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After //用于测试方法执行之后执行
    public void destory() throws IOException {
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFristLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
//        sqlSession.close();
//        //再次获取SqlSession对象
//        sqlSession = factory.openSession();

        sqlSession.clearCache();//此方法可清空缓存
        userDao = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2 );
    }

    /**
     * 测试缓存同步
     */
    @Test
    public void updateUser(){
//        1.根据ID查找用户
        User user1 = userDao.findById(41);
        System.out.println(user1);
//        2 .更新用户信息
        user1.setUsername("update user clear cache ");
        user1.setAddress("北京市海淀区");
        userDao.updateUser(user1);
//        3.再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2 );
    }
}

