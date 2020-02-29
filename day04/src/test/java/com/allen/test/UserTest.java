package com.allen.test;

import com.allen.dao.IAccount;
import com.allen.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1. 读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        sqlSession =factory.openSession();
        //4.获取dao代理对象
        userDao  = sqlSession.getMapper(IUserDao.class);
    }
    @After //用于测试方法执行之后执行
    public void  destory() throws IOException {
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    
}
