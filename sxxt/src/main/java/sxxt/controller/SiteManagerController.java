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
import sxxt.entity.SiteManager;
import sxxt.entity.Student;
import sxxt.dto.reponseDto;
import sxxt.entity.Class;
import sxxt.entity.Company;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/siteManager")
public class SiteManagerController {
	@Autowired
	private SiteManagerService siteManagerService;
	@Autowired
	private CompanyService companyService;

	// 请求跳转到场地管理员信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<SiteManager> result = siteManagerService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无场地管理员信息");
		} else {
			model.addAttribute("result", result);
		}

		return "siteManagerManage/listSiteManager";
	}

	// 请求跳转到查看场地管理员信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		SiteManager result = siteManagerService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "siteManagerManage/viewSiteManager";
	}

	// 请求跳转到添加场地管理员信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "siteManagerManage/addSiteManager";
	}

	// 请求跳转到添加场地管理员信息
	@RequestMapping(value = "doAdd")
	public String doAdd(SiteManager siteManager, Model model) {
		System.out.println(siteManager);
		siteManagerService.addSiteManager(siteManager);
		return "redirect:/siteManager/list";
	}

	// 请求跳转到修改场地管理员信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		SiteManager siteManager = siteManagerService.findById(id);
		model.addAttribute("siteManager", siteManager);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "siteManagerManage/editSiteManager";

	}

	// 请求跳转到添加单个场地管理员信息
	@RequestMapping(value = "doEdit")
	public String doEdit(SiteManager siteManager, Model model) {
		System.out.println(siteManager);
		siteManagerService.editSiteManager(siteManager);
		return "redirect:/siteManager/list";
	}

	// 请求跳转到删除单个场地管理员信息
	@RequestMapping(value = "delete")
	public String delSiteManager(int id, Model model) {
		siteManagerService.delSiteManager(id);
		return "redirect:/siteManager/list";
	}

}
