package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.Student;

public interface StudentDao {
	int addStudent(Student student);

	int editStudent(Student student);

	List<Student> findByClassId(int id);

	Student findById(int id);

	Student findByCode(String code);
	int updatePassword(@Param("code")String code,@Param("password")String password);

	int delStudent(int id);
}
