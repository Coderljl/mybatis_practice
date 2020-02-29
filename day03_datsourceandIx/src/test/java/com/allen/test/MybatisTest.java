package com.allen.test;

import com.allen.dao.IUserDao;
import com.allen.domain.QueryVo;
import com.allen.domain.User;
import com.mysql.cj.xdevapi.SqlResultBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
private InputStream in;
private SqlSession sqlSession;
private IUserDao userDao;
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException{
        //1. 读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
         sqlSession =factory.openSession();
        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After //用于测试方法执行之后执行
    public void  destory() throws IOException {
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() throws IOException {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }

    }

    @Test
    public void testFindOne()  {
        //执行查找方法
        User user= userDao.findById(1);
        System.out.println(user);
    }
    @Test
    public void testFindName()  {
        //执行查找方法
        List<User> users = userDao.findByName("%李%");
        for (User user : users){
            System.out.println(users);
        }
    }
    @Test
    public void testFindCondition()  {
        //执行查找方法
        User user = new User();
        user.setUsername("ll");
        user.setSex("男");
        List<User> users = userDao.findUserByCondition(user);
        for (User u : users){
            System.out.println(u);
        }
    }



}

