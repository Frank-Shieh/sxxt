package sxxt.dao;

import java.util.List;

import sxxt.entity.SystemManager;

public interface SystemManagerDao {
	int addSystemManager(SystemManager systemManager);

	int editSystemManager(SystemManager systemManager);

	SystemManager findById(int id);

	SystemManager findByCode(String code);

	List<SystemManager> findAll();

	int delSystemManger(int id);

}
