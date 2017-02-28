package com.hjy.chapter3.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hjy on 17-2-27.
 */
public class SqlSessionFactoryUtil {

    //SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;

    //类线程锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /*
    *   私有化构造参数
    */

    public SqlSessionFactoryUtil() {}

    /*
     * 构建SqlSessionFactory
     */
    public static SqlSessionFactory initSqlSessionFactory(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        }catch (IOException ex){
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.ERROR,null,ex);
        }
        synchronized (CLASS_LOCK){
            if (sqlSessionFactory==null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    /*
     * 打开SqlSession
     */
    public static SqlSession openSqlSession(){
        if (sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }


}
