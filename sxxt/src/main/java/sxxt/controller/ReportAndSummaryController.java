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

		System.out.println(studentList);
		return "ReportAndSummary/addReportAndSummary";
	}

	// 请求跳转到添加總結
	@RequestMapping(value = "doAdd")
	public String doAdd(ReportAndSummary reportAndSummary) {
		System.out.println(11111111);
		reportAndSummaryService.addReportAndSummary(reportAndSummary);
		return "redirect:/reportAndSummary/list";
	}

}
