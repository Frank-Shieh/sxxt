package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.SchoolTeacher;

public interface SchoolTeacherDao {
	int addSchoolTeacher(SchoolTeacher t);

	int editSchoolTeacher(SchoolTeacher t);

	List<SchoolTeacher> findAll();

	SchoolTeacher findById(int id);

	List<SchoolTeacher> findBySchoolId(int id);
	
	SchoolTeacher findByCode(String code);
	
	int delSchoolTeacher(int id);
	
	int updatePassword(@Param("code")String code,@Param("password")String password);
}
