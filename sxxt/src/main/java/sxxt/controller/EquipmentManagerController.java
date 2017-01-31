package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Company;
import sxxt.entity.EquipmentManager;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.EquipmentManagerService;

@Controller
@RequestMapping(value = "/equipmentManager")
public class EquipmentManagerController {
	@Autowired
	private EquipmentManagerService equipmentManagerService;
	@Autowired
	private CompanyService companyService;

	// 请求跳转到实训教务主管信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<EquipmentManager> result = equipmentManagerService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无实训教务主管信息");
		} else {
			System.out.println(result.get(0));
			model.addAttribute("result", result);
		}

		return "equipmentManager/listEquipmentManager";
	}

	// 请求跳转到查看实训教务主管信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		EquipmentManager result = equipmentManagerService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "equipmentManager/viewEquipmentManager";
	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "equipmentManager/addEquipmentManager";
	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "doAdd")
	public String doAdd(EquipmentManager equipmentManager, Model model) {
		System.out.println(equipmentManager);
		equipmentManagerService.addEquipmentManager(equipmentManager);
		return "redirect:/equipmentManager/list";
	}

	// 请求跳转到修改实训教务主管信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		EquipmentManager equipmentManager = equipmentManagerService.findById(id);
		model.addAttribute("equipmentManager", equipmentManager);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		return "equipmentManager/editEquipmentManager";

	}

	// 请求跳转到添加实训教务主管信息
	@RequestMapping(value = "doEdit")
	public String doEdit(EquipmentManager equipmentManager, Model model) {
		System.out.println(equipmentManager);
		equipmentManagerService.editEquipmentManager(equipmentManager);
		return "redirect:/equipmentManager/list";
	}

	// 请求跳转到删除实训教务主管信息
	@RequestMapping(value = "delete")
	public String delEquipmentManager(int id, Model model) {
		equipmentManagerService.delEquipmentManager(id);
		return "redirect:/equipmentManager/list";
	}

}
