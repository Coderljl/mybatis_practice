package com.allen.mybatis.sqlsession;

/**
 * 自定义Mybatis和数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 */
public interface SqlSession  {
    /**
     * 根据参数创建代理对象
     * @param daoInterFaceClass dao接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterFaceClass);

    //释放资源
    void close();
}
