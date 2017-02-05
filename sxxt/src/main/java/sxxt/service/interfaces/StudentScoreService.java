package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.StudentScore;

public interface StudentScoreService {
	int addStudentScore(StudentScore studentScore);

	int editStudentScore(StudentScore studentScore);

	StudentScore findByStudentId(int id);

	List<StudentScore> findByTeacherId(int id);

	StudentScore findById(int id);

	List<StudentScore> findByClassId(int id);

	List<StudentScore> findAll();

	int delStudentSocre(int id);
}
