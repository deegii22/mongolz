package com.mongolz.dao;

import com.mongolz.domain.Role;

public interface RoleDao {

    Role findRoleByName(String role);

}
