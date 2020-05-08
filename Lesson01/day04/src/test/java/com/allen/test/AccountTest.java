package com.allen.test;

import com.allen.dao.IAccount;
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
import java.sql.SQLOutput;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccount accountDao;
    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1. 读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取sqlsqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        sqlSession =factory.openSession();
        //4.获取dao代理对象
        accountDao  = sqlSession.getMapper(IAccount.class);
    }
    @After //用于测试方法执行之后执行
    public void  destory() throws IOException {
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void findAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account :accounts){
            System.out.println("-------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test
    public void findAllAccountUser(){
        List<AccountUser> aus = accountDao.findAllAccoun();
        for(AccountUser account :aus){
            System.out.println(account);
        }
    }
}
