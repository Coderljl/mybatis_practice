package com.allen.mybatis.io;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * 使用类加载器读取配置文件
 */
public class Resources {
    /**
     * 根据传入参数获取字节数入流
     * @param FilePath
     * @return
     */
    public static InputStream getResourceAsStream(String FilePath){
        return Resource.class.getClassLoader().getResourceAsStream(FilePath);
    }
}
