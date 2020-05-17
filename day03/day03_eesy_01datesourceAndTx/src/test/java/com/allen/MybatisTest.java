 package com.allen;

import com.allen.dao.IUserDao;
//import com.allen.domain.QueryVo;
import com.allen.dao.impl.UserDaoImpl;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {
private InputStream in;

private IUserDao userDao;
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException{
        //1. 读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);
    }
    @After //用于测试方法执行之后执行
    public void  destory() throws IOException {
        //6.释放资源

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
    public void testSave()  {
        User user = new User();
        user.setUsername("dao impl user ");
        user.setSex("男");
        user.setAddress("北京");
        user.setBirthday(new Date());

        //执行保存方法
        userDao.saveUser(user);

        System.out.println(user.toString());
    }
//    测试更新操作
    @Test
    public void testUpdate()  {
        User user = new User();
        user.setId(50);
        user.setUsername("李俊杰");
        user.setSex("男");
        user.setAddress("南京");
        user.setBirthday(new Date());
        System.out.println(user.toString());
        userDao.updateUser(user);
    }
    //    测试删除操作
    @Test
    public void testDelete()  {
        //执行删除方法
        userDao.deleteUser(3);

    }
    @Test
    public void testFindOne()  {
        //执行查找方法
        User user= userDao.findById(41);
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

    /**
     * 查询总记录条数
     */
    @Test
    public void testTotal()  {
        //执行查找方法
        int total = userDao.total();
        System.out.println(total);
    }


}

