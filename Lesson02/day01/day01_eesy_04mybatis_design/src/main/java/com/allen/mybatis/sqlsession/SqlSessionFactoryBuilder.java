package com.allen.mybatis.sqlsession;

import com.allen.mybatis.cfg.Configuration;
import com.allen.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.allen.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactoryBuilder对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数字节输入构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public DefaultSqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return  new DefaultSqlSessionFactory(cfg);
    }
}
