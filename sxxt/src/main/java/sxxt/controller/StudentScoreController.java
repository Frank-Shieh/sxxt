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

	// 请求跳转到班级成绩列表信息
	@RequestMapping(value = "listClass")
	public String listClass(Model model) {
		List<StudentScore> result = studentScoreService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "该班级成绩信息");
		} else {
			model.addAttribute("result", result);
		}
		return "studentScore/listClass";
	}

	// 请求跳转到学生成绩列表信息
	@RequestMapping(value = "list")
	public String list(int id, Model model) {
		List<StudentScore> result = studentScoreService.findByClassId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "该班级成绩信息");
		} else {
			model.addAttribute("result", result);
		}
		return "studentScore/listStudent";
	}

	// 请求跳转到班级成绩列表信息
	// listClassByTrainningTeacher
	@RequestMapping(value = "listClassByTT")
	public String listClassByTT(Model model) {
		List<StudentScore> result = studentScoreService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "该班级成绩信息");
		} else {
			model.addAttribute("result", result);
		}
		return "studentScore/listClassByTT";
	}

	// 请求跳转到学生成绩列表信息
	@RequestMapping(value = "listByTT")
	public String listByTT(int id, Model model) {
		List<StudentScore> result = studentScoreService.findByClassId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "该班级成绩信息");
		} else {
			model.addAttribute("result", result);
		}
		return "studentScore/listStudentByTT";
	}

	// 请求跳转到添加学生成绩信息
	@RequestMapping(value = "add")
	public String add(HttpSession httpSession, Model model) {
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

		model.addAttribute("user", httpSession.getAttribute("user"));
		return "studentScore/addStudentScore";
	}

	// 请求跳转到添加学生成绩信息
	@RequestMapping(value = "doAdd")
	public String doAdd(StudentScore studentScore, Model model) {
		System.out.println(studentScore);
		studentScoreService.addStudentScore(studentScore);
		return "redirect:/studentScore/list?id=" + studentScore.getClassId().getId();
	}

	// 请求跳转到添加学生成绩信息
	@RequestMapping(value = "edit")
	public String eidt(HttpSession httpSession, int id, Model model) {
		StudentScore studentScore = studentScoreService.findById(id);
		model.addAttribute("studentScore", studentScore);

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

		model.addAttribute("user", httpSession.getAttribute("user"));
		return "/studentScore/editStudentScore";
	}

	// 请求跳转到修改学生成绩信息
	@RequestMapping(value = "doEdit")
	public String doEdit(StudentScore studentScore, Model model) {
		System.out.println(studentScore);
		studentScoreService.editStudentScore(studentScore);
		return "redirect:/studentScore/list?id=" + studentScore.getClassId().getId();
	}

	// 请求跳转到查看学生成绩信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		StudentScore result = studentScoreService.findById(id);
		model.addAttribute("result", result);
		return "studentScore/viewStudentScore";
	}

}
