package sxxt.dao;

import java.util.List;

import sxxt.entity.EducationManager;

public interface EducationManagerDao {
	int addEducationManager(EducationManager s);

	int editEducationManager(EducationManager s);

	List<EducationManager> findAll();

	List<EducationManager> findByCompanyId(int id);

	EducationManager findById(int id);
	
	EducationManager findByCode(String code);

	int delEducationManager(int id);
}
