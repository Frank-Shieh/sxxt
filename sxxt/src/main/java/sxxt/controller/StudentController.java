package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sxxt.entity.Student;
import sxxt.entity.Class;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;

	// 请求跳转到班级人员信息列表
	@RequestMapping(value = "list")
	public String list(int id, Model model) {
		List<Student> result = studentService.findByClassId(id);
		model.addAttribute("result", result);
		return "studentManage/listStudent";
	}

	// 请求跳转到查看班级人员信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		Student result = studentService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "studentManage/viewStudent";
	}

	// 请求跳转到添加单个班级人员信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Class> classList = classService.findAll();
		model.addAttribute("classList", classList);
		
		
		return "studentManage/addStudent";
	}
}
