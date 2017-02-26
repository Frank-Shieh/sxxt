package sxxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.dto.reponseDto;
import sxxt.entity.Class;
import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;

@Controller
@RequestMapping(value = "/class")
public class ClassController {
	@Autowired
	private ClassService classService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;

	// 请求获取到列表页面
	@RequestMapping(value = "list")
	public String list(Model model,HttpSession httpSession ) {
		try {
			List<Class> result = classService.findAll();
			model.addAttribute("result", result);
			model.addAttribute("user", httpSession.getAttribute("user"));
			model.addAttribute("myheader", httpSession.getAttribute("myheader"));
			return "classManage/listClass";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMsg", "查找班级信息失败");
			return "classManage/listClass";
		}
	}

	// 添加学生界面请求添加班级
	@RequestMapping(value = "add")
	public @ResponseBody reponseDto add(int majorId, String name, Model model) {
		reponseDto reponseDto = new reponseDto();
		Class classId = new Class();
		classId.setName(name);
		Major major = new Major();
		major.setId(majorId);
		classId.setMajor(major);
		int result = classService.addClass(classId);
		if (result == 1) {
			reponseDto.setObject(classId);
			reponseDto.setLength(1);
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}
		return reponseDto;

	}

	// 请求跳转到添加单个班级信息
	@RequestMapping(value = "addClass")
	public String addClass(Model model) {
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		List<Major> majorList = majorService.findBySchoolId(schoolList.get(0).getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);

		return "classManage/addClass";
	}

	// 请求跳转到添加单个班级信息
	@RequestMapping(value = "doAdd")
	public String doAdd(Class c, Model model) {
		System.out.println(c);
		classService.addClass(c);
		return "class/list";
	}

	// 请求跳转到修改班级信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		Class classId = classService.findById(id);
		model.addAttribute("classId", classId);

		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		List<Major> majorList = majorService.findBySchoolId(classId.getMajor().getSchool().getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);

		return "classManage/editClass";
	}

	//处理修改班级信息
	@RequestMapping(value = "doEdit")
	public String doEdit(Class c) {
		System.out.println(c);
		classService.editClass(c);
		return "redirect:/class/list";
	}
	// 请求跳转到删除单个班级信息
	@RequestMapping(value = "delete")
	public String delClass(int id, Model model) {
		classService.delClass(id);
		return "redirect:/class/list";
	}
}
