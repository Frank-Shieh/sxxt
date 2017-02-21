package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.SchoolTeacher;

public interface SchoolTeacherService {
	int addSchoolTeacher(SchoolTeacher t);

	int editSchoolTeacher(SchoolTeacher t);

	List<SchoolTeacher> findAll();

	SchoolTeacher findById(int id);

	List<SchoolTeacher> findBySchoolId(int id);

	SchoolTeacher findByCode(String code);

	int delSchoolTeacher(int id);
}
