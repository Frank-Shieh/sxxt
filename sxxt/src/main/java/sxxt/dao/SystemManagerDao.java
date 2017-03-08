package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.SystemManager;

public interface SystemManagerDao {
	int addSystemManager(SystemManager systemManager);

	int editSystemManager(SystemManager systemManager);

	SystemManager findById(int id);

	SystemManager findByCode(String code);

	List<SystemManager> findAll();
	int updatePassword(@Param("code")String code,@Param("password")String password);

	int delSystemManger(int id);

}
