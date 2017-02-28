package com.hjy.chapter3.mapper;

import com.hjy.chapter3.po.Role;

/**
 * Created by hjy on 17-2-27.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public Role findRole(String roleName);
    public int deleteRole(Long id);
    public int insertRole(Role role);
}
