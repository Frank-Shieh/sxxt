package sxxt.dao;

import java.util.List;

import sxxt.entity.Role;

public interface RoleDao {
	int addRole(Role role);

	int editRole(Role role);

	Role findById(int id);

	List<Role> findAll();

	int delRole(int id);

}
