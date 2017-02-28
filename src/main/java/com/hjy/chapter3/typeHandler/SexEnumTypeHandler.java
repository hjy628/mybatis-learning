package com.hjy.chapter3.typeHandler;

import com.hjy.chapter3.enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hjy on 17-2-27.
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SexEnumTypeHandler implements TypeHandler<Sex>{

    private Logger log = Logger.getLogger(SexEnumTypeHandler.class);


    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        log.info("使用我的TypeHandler");
        preparedStatement.setInt(i,sex.getId());
    }

    public Sex getResult(ResultSet resultSet, String name) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet列名获取字符串");
        int id = resultSet.getInt(name);
        return Sex.getSex(id);
    }

    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet下标获取字符串");
        int id = resultSet.getInt(i);
        return Sex.getSex(id);
    }

    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("使用我的TypeHandler,CallableStatement下标获取字符串");
        int id = callableStatement.getInt(i);
        return Sex.getSex(id);
    }
}
