package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.School;

public interface SchoolService {
	int addSchool(School school);

	int editSchool(School school);

	School findById(int id);

	List<School> findAll();

	int delSchool(int id);

}
