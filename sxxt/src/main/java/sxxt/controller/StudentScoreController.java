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
import sxxt.entity.School;
import sxxt.entity.Student;
import sxxt.entity.StudentScore;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.StudentScoreService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/studentScore")
public class StudentScoreController {
	@Autowired
	private StudentScoreService studentScoreService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentService;

	// 请求跳转到添加学生成绩信息
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

		return "studentScore/addStudentScore";
	}

	// 请求跳转到添加学生成绩信息
	@RequestMapping(value = "doAdd")
	public String doAdd(StudentScore studentScore, Model model) {
		System.out.println(studentScore);
		studentScoreService.addStudentScore(studentScore);
		return "redirect:/studentScore/list";
	}
}
