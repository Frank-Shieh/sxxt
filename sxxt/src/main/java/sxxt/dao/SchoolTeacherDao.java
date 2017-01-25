package sxxt.dao;

import java.util.List;
import sxxt.entity.SchoolTeacher;

public interface SchoolTeacherDao {
	int addSchoolTeacher(SchoolTeacher t);

	int editSchoolTeacher(SchoolTeacher t);

	List<SchoolTeacher> findAll();

	SchoolTeacher findById(int id);

	List<SchoolTeacher> findBySchoolId(int id);
	
	int delSchoolTeacher(int id);
}
