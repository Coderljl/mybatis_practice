package com.allen;

import com.allen.dao.IAccountDao;
import com.allen.dao.IUserDao;
import com.allen.domain.Account;
import com.allen.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1. 读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After //用于测试方法执行之后执行
    public void destory() throws IOException {
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        System.out.println("******************START***********************");
        for (Account account : accounts){
            System.out.println("******************ACCOUNT***********************");
            System.out.println(account);
            System.out.println("******************USER***********************");
            System.out.println(account.getUser());
        }
        System.out.println("******************END***********************");

    }


    /**
     * 测试查询所用账户同时包含用户名称和地址
     */
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser> aus = accountDao.findAllAccount();
        System.out.println("*****************************************");
        for (AccountUser  au : aus){
            System.out.println(au);
        }
        System.out.println("*****************************************");

    }
}
