package com.mongolz.dao.impl;


import com.mongolz.dao.GenericDao;
import com.mongolz.dao.RoleDao;
import com.mongolz.domain.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl() {
        super.setDaoType(Role.class);
    }

    @Override
    public Role findRoleByName(String role) {
        Query query = entityManager.createQuery("select r from Role r  where r.role =:role");
        return (Role) query.setParameter("role", role).getSingleResult();
    }
}
