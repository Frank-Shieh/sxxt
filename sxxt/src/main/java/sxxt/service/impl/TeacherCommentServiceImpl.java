package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.TeacherCommentDao;
import sxxt.entity.TeacherComment;
import sxxt.service.interfaces.TeacherCommentService;

@Service
public class TeacherCommentServiceImpl implements TeacherCommentService {
	@Autowired
	private TeacherCommentDao teacherCommentDao;

	@Override
	public int addTeacherComment(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		int totalScore = teacherComment.getHomeworkNum() + teacherComment.getTeachingLevel()
				+ teacherComment.getTheoryActual() + teacherComment.getWorkHard();
		teacherComment.setTotalScore(totalScore);
		int result = teacherCommentDao.addTeacherComment(teacherComment);
		return result;
	}

	@Override
	public int editTeacherComment(TeacherComment teacherComment) {
		// TODO Auto-generated method stub
		int totalScore = teacherComment.getHomeworkNum() + teacherComment.getTeachingLevel()
				+ teacherComment.getTheoryActual() + teacherComment.getWorkHard();
		teacherComment.setTotalScore(totalScore);
		int result = teacherCommentDao.editTeacherComment(teacherComment);
		return result;
	}

	@Override
	public TeacherComment findById(int id) {
		// TODO Auto-generated method stub
		TeacherComment result = teacherCommentDao.findById(id);
		return result;
	}

	@Override
	public List<TeacherComment> findAll() {
		// TODO Auto-generated method stub
		List<TeacherComment> result = teacherCommentDao.findAll();
		return result;
	}

	@Override
	public List<TeacherComment> findByTeacherId(int id) {
		// TODO Auto-generated method stub
		List<TeacherComment> result = teacherCommentDao.findByTeacherId(id);
		return result;
	}

	@Override
	public List<TeacherComment> findByStudentId(int id) {
		// TODO Auto-generated method stub
		List<TeacherComment> result = teacherCommentDao.findByStudentId(id);
		return result;
	}

	@Override
	public int delTeacherComment(int id) {
		// TODO Auto-generated method stub
		int result = teacherCommentDao.delTeacherComment(id);
		return result;
	}

	@Override
	public List<TeacherComment> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<TeacherComment> result = teacherCommentDao.findByClassId(id);
		return result;
	}

}
