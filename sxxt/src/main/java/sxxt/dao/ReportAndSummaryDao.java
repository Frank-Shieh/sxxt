package sxxt.dao;

import java.util.List;

import sxxt.entity.ReportAndSummary;

public interface ReportAndSummaryDao {

	//针对学生的报告
	int addReportAndSummary(ReportAndSummary reportAndSummary);
	int editReportByStudent(ReportAndSummary reportAndSummary);
	ReportAndSummary findByStudentId(int id);

	//针对老师的报告
	int editReportByTeacher(ReportAndSummary reportAndSummary);
	
	//公用
	ReportAndSummary findById(int id);
	List<ReportAndSummary> findAll();
	List<ReportAndSummary> findByTrainningTeacher(int id);
}
