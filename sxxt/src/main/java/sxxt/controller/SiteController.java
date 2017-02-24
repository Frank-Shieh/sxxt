package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.dto.reponseDto;
import sxxt.entity.Company;
import sxxt.entity.Site;
import sxxt.entity.SiteManager;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.SiteService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/site")

public class SiteController {
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteManagerService siteManagerService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;

	// 请求跳转到场地信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Site> result = siteService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无场地信息");
		} else {
			model.addAttribute("result", result);
		}
		return "siteManage/listSite";
	}

	// 请求跳转到场地信息列表
	@RequestMapping(value = "rentAndAssign")
	public String rentAndAssign(Model model) {
		List<Site> result = siteService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无场地信息");
		} else {
			model.addAttribute("result", result);
		}

		return "siteManage/listRentAndAssign";

	}

	// 请求跳转到查看场地信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		Site result = siteService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "siteManage/viewSite";
	}

	// 请求跳转到添加场地管理员信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		List<SiteManager> siteManagerList = siteManagerService.findByCompanyId(companyList.get(0).getId());
		jsonSchool = JSON.toJSONString(siteManagerList);
		jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("siteManagerList", jsonArraySchool);

		return "siteManage/addSite";
	}

	// 请求跳转到添加场地管理员信息
	@RequestMapping(value = "doAdd")
	public String doAdd(Site site, Model model) {
		System.out.println(site);
		siteService.addSite(site);
		return "redirect:/site/list";
	}

	// 请求跳转到修改场地信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		Site site = siteService.findById(id);
		model.addAttribute("site", site);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		List<SiteManager> siteManagerList = siteManagerService.findByCompanyId(site.getCompany().getId());
		jsonSchool = JSON.toJSONString(siteManagerList);
		jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("siteManagerList", jsonArraySchool);

		return "siteManage/editSite";

	}

	// 请求跳转到添加单个场地信息
	@RequestMapping(value = "doEdit")
	public String doEdit(Site site, Model model) {
		System.out.println(site);
		siteService.editSite(site);
		return "redirect:/site/list";
	}

	// 修改租借
	@RequestMapping(value = "rent")
	public String rent(int id, Model model) {
		Site site = siteService.findById(id);
		model.addAttribute("site", site);
		return "siteManage/editRent";
	}

	@RequestMapping(value = "doRent")
	public String doRent(Site site, Model model) {
		System.out.println(site);
		siteService.editRent(site);
		return "redirect:/site/rentAndAssign";
	}

	// 修改分配
	@RequestMapping(value = "assign")
	public String assign(int id, Model model) {
		Site site = siteService.findById(id);
		model.addAttribute("site", site);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		TrainningTeacher t;

		if (site.getTrainningTeacher() == null) {
			t = trainningTeacherService.findByCompanyId(companyList.get(0).getId()).get(0);
			site.setTrainningTeacher(t);
		} else {
			t = trainningTeacherService.findById(site.getTrainningTeacher().getId());
			site.setTrainningTeacher(t);

		}
		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findByCompanyId(t.getCompany().getId());
		jsonSchool = JSON.toJSONString(trainningTeacherList);
		jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("trainningTeacherList", jsonArraySchool);
		return "siteManage/editAssign";
	}

	@RequestMapping(value = "doAssign")
	public String doAssign(Site site, Model model) {
		System.out.println(site);
		siteService.editAssign(site);
		return "redirect:/site/rentAndAssign";
	}

	// 请求跳转到删除单个场地信息
	@RequestMapping(value = "delete")
	public String delSite(int id, Model model) {
		siteService.delSite(id);
		return "redirect:/site/list";
	}
	
	// 请求跳转到撤销场地状态
		@RequestMapping(value = "delState")
		public String delState(int id, Model model) {
			siteService.delState(id);
			return "redirect:/site/rentAndAssign";
		}
	// 请求查找新的场地管理员列表
	@RequestMapping(value = "findByCompanyId")
	public @ResponseBody reponseDto findByCompanyId(int id, Model model) {

		List<SiteManager> siteManagerList = siteManagerService.findByCompanyId(id);
		reponseDto reponseDto = new reponseDto();
		if (siteManagerList != null) {
			String jsonMajor = JSON.toJSONString(siteManagerList);
			JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
			reponseDto.setObject(jsonArrayMajor);
			reponseDto.setLength(siteManagerList.size());
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}

		return reponseDto;
	}

	// 请求查找新的实训教师列表
	@RequestMapping(value = "findTrainningTeacher")
	public @ResponseBody reponseDto findTrainningTeacher(int id, Model model) {

		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findByCompanyId(id);
		reponseDto reponseDto = new reponseDto();
		if (trainningTeacherList != null) {
			String jsonMajor = JSON.toJSONString(trainningTeacherList);
			JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
			reponseDto.setObject(jsonArrayMajor);
			reponseDto.setLength(trainningTeacherList.size());
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}

		return reponseDto;
	}

}
