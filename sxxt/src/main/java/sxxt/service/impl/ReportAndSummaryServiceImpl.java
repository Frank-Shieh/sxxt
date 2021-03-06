package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.AllocateClassDao;
import sxxt.dao.ReportAndSummaryDao;
import sxxt.dao.StudentDao;
import sxxt.entity.ClassTeacherRelationship;
import sxxt.entity.ReportAndSummary;
import sxxt.entity.Student;
import sxxt.service.interfaces.ReportAndSummaryService;

@Service
public class ReportAndSummaryServiceImpl implements ReportAndSummaryService {
	@Autowired
	private ReportAndSummaryDao reportAndSummaryDao;
	@Autowired
	private AllocateClassDao allocateClassDao;
	@Autowired
	private StudentDao studentDao;

	@Override
	public int addReportAndSummary(ReportAndSummary reportAndSummary) {
		// TODO Auto-generated method stub
		Student s = studentDao.findById(reportAndSummary.getStudent().getId());
		List<ClassTeacherRelationship> c = allocateClassDao.findByClassId(s.getClassId().getId());
		reportAndSummary.setTrainningTeacher(c.get(0).getTrainningTeacher());
		int result = reportAndSummaryDao.addReportAndSummary(reportAndSummary);
		return result;
	}

	@Override
	public int editReportByStudent(ReportAndSummary reportAndSummary) {
		// TODO Auto-generated method stub
		Student s = studentDao.findById(reportAndSummary.getStudent().getId());
		List<ClassTeacherRelationship> c = allocateClassDao.findByClassId(s.getClassId().getId());
		reportAndSummary.setTrainningTeacher(c.get(0).getTrainningTeacher());
		int result = reportAndSummaryDao.editReportByStudent(reportAndSummary);
		return result;
	}

	@Override
	public ReportAndSummary findByStudentId(int id) {
		// TODO Auto-generated method stub
		ReportAndSummary result = reportAndSummaryDao.findByStudentId(id);
		return result;
	}

	@Override
	public int editReportByTeacher(ReportAndSummary reportAndSummary) {
		// TODO Auto-generated method stub
		int result = reportAndSummaryDao.editReportByTeacher(reportAndSummary);
		return result;
	}

	@Override
	public ReportAndSummary findById(int id) {
		// TODO Auto-generated method stub
		ReportAndSummary result = reportAndSummaryDao.findById(id);
		return result;
	}

	@Override
	public List<ReportAndSummary> findAll() {
		// TODO Auto-generated method stub
		List<ReportAndSummary> result = reportAndSummaryDao.findAll();
		return result;
	}

	@Override
	public List<ReportAndSummary> findByTrainningTeacher(int id) {
		// TODO Auto-generated method stub
		List<ReportAndSummary> result = reportAndSummaryDao.findByTrainningTeacher(id);
		return result;
	}

}
