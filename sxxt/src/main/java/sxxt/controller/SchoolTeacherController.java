package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Company;
import sxxt.entity.School;
import sxxt.entity.SchoolTeacher;
import sxxt.entity.SiteManager;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.SchoolTeacherService;

@Controller
@RequestMapping(value = "/schoolTeacher")
public class SchoolTeacherController {
	@Autowired
	SchoolTeacherService schoolTeacherService;
	@Autowired
	SchoolService schoolService;

	// 请求跳转到学校教师信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<SchoolTeacher> result = schoolTeacherService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无学校教师信息");
		} else {
			model.addAttribute("result", result);
		}

		return "schoolTeacherManage/listSchoolTeacher";
	}

	// 请求跳转到查看学校教师信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		SchoolTeacher result = schoolTeacherService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "schoolTeacherManage/viewSchoolTeacher";
	}

	// 请求跳转到添加学校教师信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		return "schoolTeacherManage/addSchoolTeacher";
	}

	// 请求跳转到添加学校教师信息
	@RequestMapping(value = "doAdd")
	public String doAdd(SchoolTeacher schoolTeacher, Model model) {
		System.out.println(schoolTeacher);
		schoolTeacherService.addSchoolTeacher(schoolTeacher);
		return "redirect:/schoolTeacher/list";
	}

	// 请求跳转到修改场地管理员信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		SchoolTeacher schoolTeacher = schoolTeacherService.findById(id);

		model.addAttribute("schoolTeacher", schoolTeacher);
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		return "schoolTeacherManage/editSchoolTeacher";

	}

	// 请求跳转到添加单个场地管理员信息
	@RequestMapping(value = "doEdit")
	public String doEdit(SchoolTeacher schoolTeacher, Model model) {
		System.out.println(schoolTeacher);
		schoolTeacherService.editSchoolTeacher(schoolTeacher);
		return "redirect:/schoolTeacher/list";
	}

	// 请求跳转到删除单个场地管理员信息
	@RequestMapping(value = "delete")
	public String delSchoolTeacher(int id, Model model) {
		schoolTeacherService.delSchoolTeacher(id);
		return "redirect:/schoolTeacher/list";
	}

}
