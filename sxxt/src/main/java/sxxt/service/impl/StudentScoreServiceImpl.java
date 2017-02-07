package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.AllocateClassDao;
import sxxt.dao.StudentScoreDao;
import sxxt.entity.ClassTeacherRelationship;
import sxxt.entity.StudentScore;
import sxxt.service.interfaces.StudentScoreService;

@Service
public class StudentScoreServiceImpl implements StudentScoreService {

	@Autowired
	private StudentScoreDao studentScoreDao;
	@Autowired
	private AllocateClassDao allocateClassDao;

	@Override
	public int addStudentScore(StudentScore studentScore) {
		// TODO Auto-generated method stub
		List<ClassTeacherRelationship> c = allocateClassDao.findByClassId(studentScore.getClassId().getId());
		studentScore.setTrainningTeacher(c.get(0).getTrainningTeacher());
		double totalScore = studentScore.getDesignImplement() + studentScore.getInducingAbility()
				+ studentScore.getPlanExecute() + studentScore.getProfessionalism() + studentScore.getSkillLearning()
				+ studentScore.getTeamAbility() + studentScore.getWritingLevel();
		studentScore.setTotalScore(totalScore);
		int result = studentScoreDao.addStudentScore(studentScore);
		return result;

	}

	@Override
	public int editStudentScore(StudentScore studentScore) {
		// TODO Auto-generated method stub
		List<ClassTeacherRelationship> c = allocateClassDao.findByClassId(studentScore.getClassId().getId());
		studentScore.setTrainningTeacher(c.get(0).getTrainningTeacher());
		double totalScore = studentScore.getDesignImplement() + studentScore.getInducingAbility()
				+ studentScore.getPlanExecute() + studentScore.getProfessionalism() + studentScore.getSkillLearning()
				+ studentScore.getTeamAbility() + studentScore.getWritingLevel();
		studentScore.setTotalScore(totalScore);
		int result = studentScoreDao.editStudentScore(studentScore);
		return result;
	}

	@Override
	public StudentScore findByStudentId(int id) {
		// TODO Auto-generated method stub
		StudentScore s = studentScoreDao.findByStudentId(id);
		return s;
	}

	@Override
	public List<StudentScore> findByTeacherId(int id) {
		// TODO Auto-generated method stub
		List<StudentScore> s = studentScoreDao.findByTeacherId(id);
		return s;
	}

	@Override
	public StudentScore findById(int id) {
		// TODO Auto-generated method stub
		StudentScore s = studentScoreDao.findById(id);
		return s;
	}

	@Override
	public List<StudentScore> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<StudentScore> s = studentScoreDao.findByClassId(id);
		return s;
	}

	@Override
	public List<StudentScore> findAll() {
		// TODO Auto-generated method stub
		List<StudentScore> s = studentScoreDao.findAll();
		return s;
	}

	@Override
	public int delStudentSocre(int id) {
		// TODO Auto-generated method stub
		int result = studentScoreDao.delStudentSocre(id);
		return result;
	}

}
