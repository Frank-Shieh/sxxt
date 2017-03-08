package sxxt.controller;

import java.util.List;

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
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentService;

	// 请求添加总结
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);
		
		List<Major> majorList = majorService.findBySchoolId(schoolList.get(0).getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);
		
		List<Class> classList = classService.findByMajorId(majorList.get(0).getId());
		String jsonClass = JSON.toJSONString(classList);
		JSONArray jsonArrayClass = JSON.parseArray(jsonClass);
		model.addAttribute("classList", jsonArrayClass);
		
		List<Student> studentList = studentService.findByClassId(classList.get(0).getId());
		String jsonStudent = JSON.toJSONString(studentList);
		JSONArray jsonArrayStudent = JSON.parseArray(jsonStudent);
		model.addAttribute("studentList", jsonArrayStudent);

		System.out.println(studentList);
		return "ReportAndSummary/addReportAndSummary";
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "doAdd")
	public String doAdd(ReportAndSummary reportAndSummary) {
		System.out.println(11111111);
		reportAndSummaryService.addReportAndSummary(reportAndSummary);
		return "redirect:/reportAndSummary/list";
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
		
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);
		System.out.println(schoolList);
		List<Major> majorList = majorService.findBySchoolId(schoolList.get(0).getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);
		System.out.println(majorList);
		List<Class> classList = classService.findByMajorId(majorList.get(0).getId());
		String jsonClass = JSON.toJSONString(classList);
		JSONArray jsonArrayClass = JSON.parseArray(jsonClass);
		model.addAttribute("classList", jsonArrayClass);
		System.out.println(classList);
		System.out.println(classList.get(0).getId());
		List<Student> studentList = studentService.findByClassId(classList.get(0).getId());
		String jsonStudent = JSON.toJSONString(studentList);
		JSONArray jsonArrayStudent = JSON.parseArray(jsonStudent);
		model.addAttribute("studentList", jsonArrayStudent);
		
		
		ReportAndSummary result = reportAndSummaryService.findById(id);
		model.addAttribute("result", result);
		return "ReportAndSummary/editReportAndSummary";
	}

	// 请求跳转到添加总结
	@RequestMapping(value = "doEdit")
	public String doEdit(ReportAndSummary reportAndSummary) {
		System.out.println(reportAndSummary);
		reportAndSummaryService.editReportByStudent(reportAndSummary);
		return "redirect:/reportAndSummary/list";
	}
}
