package sxxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Class;
import sxxt.entity.Major;
import sxxt.entity.ReportAndSummary;
import sxxt.entity.School;
import sxxt.entity.Student;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.ReportAndSummaryService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/reportAndSummary")

public class ReportAndSummaryController {

	@Autowired
	private ReportAndSummaryService reportAndSummaryService;

	// 请求添加总结
	@RequestMapping(value = "add")
	public String add(int id, HttpSession httpSession, Model model) {

		if (reportAndSummaryService.findByStudentId(id) == null) {
			model.addAttribute("user", httpSession.getAttribute("user"));
			return "ReportAndSummary/addReportAndSummary";
		} else {
			return "redirect:/reportAndSummary/edit?id=" + reportAndSummaryService.findByStudentId(id).getId();
		}
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "doAdd")
	public String doAdd(ReportAndSummary reportAndSummary) {
		reportAndSummaryService.addReportAndSummary(reportAndSummary);
		int r= reportAndSummary.getStudent().getId();
		return "redirect:/reportAndSummary/viewByStudent?id="+r;
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<ReportAndSummary> result = reportAndSummaryService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无报告与总结信息");
		} else {
			model.addAttribute("result", result);
		}
		return "ReportAndSummary/listReportAndSummary";
	}
	// 请求跳转到添加总结
		@RequestMapping(value = "listByTrainningTeacher")
		public String listByTrainningTeacher(int id,Model model) {
			List<ReportAndSummary> result = reportAndSummaryService.findByTrainningTeacher(id);
			if (result.size() == 0) {
				model.addAttribute("errorMsg", "暂无报告与总结信息");
			} else {
				model.addAttribute("result", result);
			}
			return "ReportAndSummary/listByTrainningTeacher";
		}
	// 请求跳转到添加总结
	@RequestMapping(value = "listOnly")
	public String listOnly(Model model) {
		List<ReportAndSummary> result = reportAndSummaryService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无报告与总结信息");
		} else {
			model.addAttribute("result", result);
		}
		return "ReportAndSummary/listOnly";
	}

	// 请求跳转到查看学校教师信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		ReportAndSummary result = reportAndSummaryService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "ReportAndSummary/viewReportAndSummary";
	}

	// 请求跳转到查看学校教师信息
	@RequestMapping(value = "viewOnly")
	public String viewOnly(int id, Model model) {
		ReportAndSummary result = reportAndSummaryService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "ReportAndSummary/viewOnly";
	}
	// 请求跳转到查看学校教师信息
		@RequestMapping(value = "viewByStudent")
		public String viewByStudent(int id, Model model) {
			ReportAndSummary result = reportAndSummaryService.findByStudentId(id);
			System.out.println(result);
			model.addAttribute("result", result);
			return "ReportAndSummary/viewByStudent";
		}
	// 教师评价学生总结
	@RequestMapping(value = "comment")
	public String comment(int id, Model model) {
		ReportAndSummary result = reportAndSummaryService.findById(id);
		model.addAttribute("result", result);
		return "ReportAndSummary/commentReportAndSummary";
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "doComment")
	public String editByTeacher(ReportAndSummary reportAndSummary) {
		System.out.println(reportAndSummary);
		reportAndSummaryService.editReportByTeacher(reportAndSummary);
		return "redirect:/reportAndSummary/list";
	}

	// 学生修改总结
	@RequestMapping(value = "edit")
	public String editByStudent(int id, Model model) {

		ReportAndSummary result = reportAndSummaryService.findById(id);
		model.addAttribute("result", result);
		return "ReportAndSummary/editReportAndSummary";
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "doEdit")
	public String doEdit(ReportAndSummary reportAndSummary) {
		reportAndSummaryService.editReportByStudent(reportAndSummary);
		int r= reportAndSummary.getStudent().getId();
		return "redirect:/reportAndSummary/viewByStudent?id="+r;
	}
}
