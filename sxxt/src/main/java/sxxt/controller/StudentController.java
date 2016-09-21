package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.entity.Student;
import sxxt.dto.reponseDto;
import sxxt.entity.Class;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
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

		return "studentManage/addStudent";
	}

	// 请求查找新的专业列表
	@RequestMapping(value = "findBySchoolId")
	public @ResponseBody reponseDto findBySchoolId(int id, Model model) {

		List<Major> majorList = majorService.findBySchoolId(id);
		reponseDto reponseDto = new reponseDto();
		if (majorList != null) {
			String jsonMajor = JSON.toJSONString(majorList);
			JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
			reponseDto.setObject(jsonArrayMajor);
			reponseDto.setLength(majorList.size());
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}

		return reponseDto;
	}

	// 请求查找新的班级列表
	@RequestMapping(value = "findByMajorId")
	public @ResponseBody reponseDto findByMajorId(int id, Model model) {
		reponseDto reponseDto = new reponseDto();


			List<Class> classList = classService.findByMajorId(id);
			if (classList != null && classList.size()>0) {
				String jsonClass = JSON.toJSONString(classList);
				JSONArray jsonArrayClass = JSON.parseArray(jsonClass);
				reponseDto.setObject(jsonArrayClass);
				reponseDto.setLength(classList.size());
			} else {
				reponseDto.setObject(null);
				reponseDto.setLength(0);
			}
	
		return reponseDto;
	}

}
