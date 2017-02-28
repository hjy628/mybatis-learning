package com.hjy.chapter3.main;

import com.hjy.chapter3.mapper.RoleMapper;
import com.hjy.chapter3.po.Role;
import com.hjy.chapter3.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by hjy on 17-2-27.
 */
public class Chapter3Main {
    public static void main(String[] args) throws Exception{

        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
          /*  Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            roleMapper.insertRole(role);
            roleMapper.deleteRole(2L);*/

          Role role = roleMapper.findRole("testName");
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
