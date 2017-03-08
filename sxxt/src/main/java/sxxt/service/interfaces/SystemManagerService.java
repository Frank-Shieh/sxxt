package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.SystemManager;

public interface SystemManagerService {
	int addSystemManager(SystemManager systemManager);

	int editSystemManager(SystemManager systemManager);

	SystemManager findById(int id);

	SystemManager findByCode(String code);

	List<SystemManager> findAll();
	int updatePassword(String code, String password);

	int delSystemManger(int id);
}
