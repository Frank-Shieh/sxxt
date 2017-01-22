package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sxxt.entity.Company;
import sxxt.service.interfaces.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	// 请求获取到列表页面
	@RequestMapping(value = "list")
	public String list(Model model) {
		try {
			List<Company> result = companyService.findAll();
			model.addAttribute("result", result);
			return "companyManage/listCompany";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMsg", "查找公司信息失败");
			return "companyManage/listCompany";
		}
	}

	// 请求获取到详情页面
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		try {
			Company result = companyService.findById(id);
			model.addAttribute("result", result);
			return "companyManage/viewCompany";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMsg", "查找公司信息失败");
			return "companyManage/listCompany";
		}
	}

	// 请求跳转到添加实训公司信息
	@RequestMapping(value = "add")
	public String add(Model model) {

		return "companyManage/addCompany";
	}

	// 请求跳转到添加实训公司信息
	@RequestMapping(value = "doAdd")
	public String doAdd(Company c, Model model) {
		System.out.println(c);
		companyService.addCompany(c);
		return "redirect:/company/list";
	}

	// 请求跳转到修改实训公司信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		Company c = companyService.findById(id);
		model.addAttribute("company", c);
		return "companyManage/editCompany";
	}

	// 处理修改实训公司信息
	@RequestMapping(value = "doEdit")
	public String doEdit(Company c) {
		System.out.println(c);
		companyService.editCompany(c);
		return "redirect:/company/list";
	}

	// 请求跳转到删除实训公司信息
	@RequestMapping(value = "delete")
	public String delCompany(int id, Model model) {
		companyService.delCompany(id);
		return "redirect:/company/list";
	}
}
