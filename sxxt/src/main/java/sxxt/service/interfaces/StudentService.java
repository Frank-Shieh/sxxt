package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.Student;

public interface StudentService {
	int addStudent(Student student);

	int editStudent(Student student);

	List<Student> findByClassId(int id);

	Student findById(int id);

	int delStudent(int id);
}