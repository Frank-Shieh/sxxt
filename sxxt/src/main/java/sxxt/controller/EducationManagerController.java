package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Company;
import sxxt.entity.EducationManager;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.EducationManagerService;

@Controller
@RequestMapping(value = "/educationManager")
public class EducationManagerController {
	@Autowired
	private EducationManagerService educationManagerService;
	@Autowired
	private CompanyService companyService;

	// 请求跳转到实训教务主管信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<EducationManager> result = educationManagerService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无实训教务主管信息");
		} else {
			System.out.println(result.get(0));
			model.addAttribute("result", result);
		}

		return "educationManager/listEducationManager";
	}

	// 请求跳转到查看实训教务主管信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		EducationManager result = educationManagerService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "educationManager/viewEducationManager";
	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "educationManager/addEducationManager";
	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "doAdd")
	public String doAdd(EducationManager educationManager, Model model) {
		System.out.println(educationManager);
		educationManagerService.addEducationManager(educationManager);
		return "redirect:/educationManager/list";
	}

	// 请求跳转到修改实训教务主管信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		EducationManager educationManager = educationManagerService.findById(id);
		model.addAttribute("educationManager", educationManager);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "educationManager/editEducationManager";

	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "doEdit")
	public String doEdit(EducationManager educationManager, Model model) {
		System.out.println(educationManager);
		educationManagerService.editEducationManager(educationManager);
		return "redirect:/educationManager/list";
	}

	// 请求跳转到删除实训教务主管信息
	@RequestMapping(value = "delete")
	public String delEducationManager(int id, Model model) {
		educationManagerService.delEducationManager(id);
		return "redirect:/educationManager/list";
	}

}
