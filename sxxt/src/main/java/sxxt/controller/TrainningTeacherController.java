package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Company;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/trainningTeacher")
public class TrainningTeacherController {
	@Autowired
	private TrainningTeacherService TrainningTeacherService;
	@Autowired
	private CompanyService companyService;

	// 请求跳转到实训教师信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<TrainningTeacher> result = TrainningTeacherService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无实训教师信息");
		} else {
			model.addAttribute("result", result);
		}

		return "TrainningTeacherManage/listTrainningTeacher";
	}

	// 请求跳转到查看实训教师信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		TrainningTeacher result = TrainningTeacherService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "TrainningTeacherManage/viewTrainningTeacher";
	}

	// 请求跳转到添加实训教师信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "TrainningTeacherManage/addTrainningTeacher";
	}

	// 请求跳转到添加实训教师信息
	@RequestMapping(value = "doAdd")
	public String doAdd(TrainningTeacher TrainningTeacher, Model model) {
		System.out.println(TrainningTeacher);
		TrainningTeacherService.addTrainningTeacher(TrainningTeacher);
		return "redirect:/trainningTeacher/list" ;
	}

	// 请求跳转到修改实训教师信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		TrainningTeacher TrainningTeacher = TrainningTeacherService.findById(id);
		model.addAttribute("trainningTeacher", TrainningTeacher);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "TrainningTeacherManage/editTrainningTeacher";

	}

	// 请求跳转到添加单个实训教师信息
	@RequestMapping(value = "doEdit")
	public String doEdit(TrainningTeacher TrainningTeacher, Model model) {
		System.out.println(TrainningTeacher);
		TrainningTeacherService.editTrainningTeacher(TrainningTeacher);
		return "redirect:/trainningTeacher/list";
	}

	// 请求跳转到删除单个实训教师信息
	@RequestMapping(value = "delete")
	public String delTrainningTeacher(int id, Model model) {
		TrainningTeacherService.delTrainningTeacher(id);
		return "redirect:/trainningTeacher/list";
	}

}
