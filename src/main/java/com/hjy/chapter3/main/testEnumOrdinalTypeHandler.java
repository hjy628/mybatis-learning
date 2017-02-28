package com.hjy.chapter3.main;

import com.hjy.chapter3.enums.Sex;
import com.hjy.chapter3.mapper.RoleMapper;
import com.hjy.chapter3.mapper.UserMapper;
import com.hjy.chapter3.po.Role;
import com.hjy.chapter3.po.User;
import com.hjy.chapter3.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;

/**
 * Created by hjy on 17-2-27.
 */
public class testEnumOrdinalTypeHandler {
    public static void main(String[] args) throws Exception{

        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("zhangsan");
            user.setCnname("张三");
            user.setMobile("18888888888");
            user.setBirthday(LocalDateTime.now().toString());
            user.setSex(Sex.MALE);
            user.setEmail("zhangsan@163.com");
            user.setNote("test  EnumOrdinalTypeHandler!!");
            userMapper.insertUser(user);
            User user1 = userMapper.getUser(1L);
            System.out.println(user1.getSex());
            sqlSession.commit();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
