package com.allen.test;

import com.allen.dao.IUserDao;
import com.allen.domain.User;
import com.mysql.cj.xdevapi.SqlResultBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testFindAll() throws IOException {
        //1. 读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        SqlSession sqlSession =factory.openSession();
        //4.获取dao代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        //5.执行查询所有方法
        List<User> users = iUserDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }

}