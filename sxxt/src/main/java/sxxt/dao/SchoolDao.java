package sxxt.dao;

import java.util.List;

import sxxt.entity.School;

public interface SchoolDao {
	int addSchool(School school);

	int editSchool(School school);

	School findById(int id);

	List<School> findAll();

	int delSchool(int id);

}
