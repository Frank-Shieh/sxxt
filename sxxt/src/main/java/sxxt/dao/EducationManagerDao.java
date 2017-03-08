package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.EducationManager;

public interface EducationManagerDao {
	int addEducationManager(EducationManager s);

	int editEducationManager(EducationManager s);

	List<EducationManager> findAll();

	List<EducationManager> findByCompanyId(int id);

	EducationManager findById(int id);

	EducationManager findByCode(String code);

	int updatePassword(@Param("code") String code, @Param("password") String password);

	int delEducationManager(int id);
}
