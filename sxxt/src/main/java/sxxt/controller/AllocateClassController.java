package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Class;
import sxxt.entity.ClassTeacherRelationship;
import sxxt.entity.EducationManager;
import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.entity.TaskTeacherRelationship;
import sxxt.entity.TeachingTask;
import sxxt.service.interfaces.AllocateClassService;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;

@Controller
@RequestMapping(value = "/allocateClass")

public class AllocateClassController {

	@Autowired
	AllocateClassService allocateClassService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ClassService classService;

	// 请求跳转到班级分配列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<ClassTeacherRelationship> result = allocateClassService.findAll();
		System.out.println(result.get(0));
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无班级分配信息");
		} else {
			model.addAttribute("result", result);
		}
		return "AllocateClass/listAllocateClass";
	}

	// 请求跳转到查看班级分配信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		ClassTeacherRelationship result = allocateClassService.findById(id);
		model.addAttribute("result", result);
		List<ClassTeacherRelationship> teacherList = allocateClassService.findByClassId(result.getClassId().getId());
		String jsonTeacher = JSON.toJSONString(teacherList);
		JSONArray jsonArrayTeacher = JSON.parseArray(jsonTeacher);
		model.addAttribute("teacherList", jsonArrayTeacher);

		return "AllocateClass/viewAllocateClass";
	}

	// 请求跳转到添加班级分配信息
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

		return "AllocateClass/addAllocateClass";
	}

	@RequestMapping(value = "doAdd")
	public String doAdd(int classId, String[] trainningTeacherCode) {
		allocateClassService.addRelationship(classId, trainningTeacherCode);
		return "redirect:/allocateClass/list";
	}

	// 请求跳转到修改班级分配信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		ClassTeacherRelationship result = allocateClassService.findById(id);
		model.addAttribute("result", result);
		List<ClassTeacherRelationship> teacherList = allocateClassService.findByClassId(result.getClassId().getId());
		String jsonTeacher = JSON.toJSONString(teacherList);
		JSONArray jsonArrayTeacher = JSON.parseArray(jsonTeacher);
		model.addAttribute("teacherList", jsonArrayTeacher);

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

		return "AllocateClass/editAllocateClass";
	}

	@RequestMapping(value = "doEdit")
	public String doEdit(int classId, String[] trainningTeacherCode) {
		allocateClassService.editRelationship(classId, trainningTeacherCode);
		return "redirect:/allocateClass/list";
	}
	@RequestMapping(value = "delete")
	public String delRelationship(int id) {
		allocateClassService.delRelationship(id);
		return "redirect:/allocateClass/list";
	}
}
