package com.hjy.chapter2.mapper;

import com.hjy.chapter2.po.Role;

/**
 * Created by hjy on 17-2-27.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public int deleteRole(Long id);
    public int insertRole(Role role);
}
