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
import sxxt.entity.Major;
import sxxt.entity.Site;
import sxxt.entity.SiteManager;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.SiteService;

@Controller
@RequestMapping(value = "/site")

public class SiteController {
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteManagerService siteManagerService;
	@Autowired
	private CompanyService companyService;

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

	// 请求跳转到删除单个场地信息
	@RequestMapping(value = "delete")
	public String delSite(int id, Model model) {
		siteService.delSite(id);
		return "redirect:/site/list";
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

	
}
