package com.hjy.chapter3.mapper;

import com.hjy.chapter3.po.User;

/**
 * Created by hjy on 17-2-27.
 */
public interface UserMapper {
    User getUser(Long id);
    int insertUser(User user);

}
