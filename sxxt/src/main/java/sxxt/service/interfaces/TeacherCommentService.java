package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.TeacherComment;

public interface TeacherCommentService {
	int addTeacherComment(TeacherComment teacherComment);

	int editTeacherComment(TeacherComment teacherComment);

	TeacherComment findById(int id);

	List<TeacherComment> findAll();

	List<TeacherComment> findByTeacherId(int id);

	List<TeacherComment> findByClassId(int id);

	List<TeacherComment> findByStudentId(int id);

	int delTeacherComment(int id);
}
