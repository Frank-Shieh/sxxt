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
import sxxt.entity.Company;
import sxxt.entity.EquipmentInfo;
import sxxt.entity.EquipmentManager;
import sxxt.entity.Site;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.CompanyService;
import sxxt.service.interfaces.EquipmentInfoService;
import sxxt.service.interfaces.EquipmentManagerService;
import sxxt.service.interfaces.SiteService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/equipmentInfo")
public class EquipmentInfoController {
	@Autowired
	private EquipmentInfoService equipmentInfoService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private EquipmentManagerService equipmentManagerService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;

	// 请求跳转到场地信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<EquipmentInfo> result = equipmentInfoService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无相关设备信息");
		} else {
			model.addAttribute("result", result);
		}
		return "equipmentInfoManage/listEquipmentInfo";
	}

	// 请求跳转到添加场地设备信息
	@RequestMapping(value = "add")
	public String add(HttpSession httpSession, Model model) {
		List<Site> siteList = siteService.findAll();
		String jsonSite = JSON.toJSONString(siteList);
		JSONArray jsonArraySite = JSON.parseArray(jsonSite);
		model.addAttribute("siteList", jsonArraySite);
		model.addAttribute("user", httpSession.getAttribute("user"));
		return "equipmentInfoManage/addEquipmentInfo";
	}

	// 请求跳转到添加场地设备信息
	@RequestMapping(value = "doAdd")
	public String doAdd(EquipmentInfo equipmentInfo, Model model) {
		System.out.println(equipmentInfo);
		equipmentInfoService.addEquipmentInfo(equipmentInfo);
		return "redirect:/equipmentInfo/list";
	}

	// 请求跳转到查看场地设备信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		EquipmentInfo e = equipmentInfoService.findById(id);
		model.addAttribute("result", e);
		return "equipmentInfoManage/viewEquipmentInfo";
	}

	// 请求跳转到查看场地设备信息
	@RequestMapping(value = "viewRentAndAssign")
	public String viewRentAndAssign(int id, Model model) {
		EquipmentInfo e = equipmentInfoService.findById(id);
		model.addAttribute("result", e);
		return "equipmentInfoManage/viewRentAndAssign";
	}

	// 请求跳转到修改场地信息
	@RequestMapping(value = "edit")
	public String edit(HttpSession httpSession, int id, Model model) {
		EquipmentInfo e = equipmentInfoService.findById(id);
		model.addAttribute("result", e);

		List<Site> siteList = siteService.findAll();
		String jsonSite = JSON.toJSONString(siteList);
		JSONArray jsonArraySite = JSON.parseArray(jsonSite);
		model.addAttribute("siteList", jsonArraySite);

		model.addAttribute("user", httpSession.getAttribute("user"));
		return "equipmentInfoManage/editEquipmentInfo";

	}

	// 请求跳转到修改场地设备信息
	@RequestMapping(value = "doEdit")
	public String doEdit(EquipmentInfo equipmentInfo, Model model) {
		System.out.println(equipmentInfo);
		equipmentInfoService.editEquipmentInfo(equipmentInfo);
		return "redirect:/equipmentInfo/list";
	}

	// 请求跳转到删除场地设备信息
	@RequestMapping(value = "delete")
	public String delEquipmentInfo(int id, Model model) {
		equipmentInfoService.delEquipmentInfo(id);
		return "redirect:/equipmentInfo/list";
	}

	// 请求跳转到租借与分配列表
	@RequestMapping(value = "rentAndAssign")
	public String rentAndAssign(Model model) {
		List<EquipmentInfo> result = equipmentInfoService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无场地设备信息");
		} else {
			model.addAttribute("result", result);
		}

		return "equipmentInfoManage/listRentAndAssign";

	}

	// 修改租借
	@RequestMapping(value = "rent")
	public String rent(int id, Model model) {
		EquipmentInfo equipmentInfo = equipmentInfoService.findById(id);
		model.addAttribute("result", equipmentInfo);
		return "equipmentInfoManage/editRent";
	}

	@RequestMapping(value = "doRent")
	public String doRent(EquipmentInfo equipmentInfo, Model model) {
		equipmentInfoService.editRent(equipmentInfo);
		return "redirect:/equipmentInfo/rentAndAssign";
	}

	// 修改分配
	@RequestMapping(value = "assign")
	public String assign(int id, Model model) {
		EquipmentInfo equipmentInfo = equipmentInfoService.findById(id);

		List<Company> companyList = companyService.findAll();
		String jsonSchool = JSON.toJSONString(companyList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("companyList", jsonArraySchool);

		TrainningTeacher t;

		if (equipmentInfo.getTrainningTeacher() == null) {
			t = trainningTeacherService.findByCompanyId(companyList.get(0).getId()).get(0);
			equipmentInfo.setTrainningTeacher(t);
		} else {
			t = trainningTeacherService.findById(equipmentInfo.getTrainningTeacher().getId());
			equipmentInfo.setTrainningTeacher(t);
		}
		model.addAttribute("result", equipmentInfo);
		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findByCompanyId(t.getCompany().getId());
		jsonSchool = JSON.toJSONString(trainningTeacherList);
		jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("trainningTeacherList", jsonArraySchool);
		return "equipmentInfoManage/editAssign";
	}

	@RequestMapping(value = "doAssign")
	public String doAssign(EquipmentInfo equipmentInfo, Model model) {
		System.out.println(equipmentInfo);
		equipmentInfoService.editAssign(equipmentInfo);
		return "redirect:/equipmentInfo/rentAndAssign";
	}

	// 请求跳转到撤销设备状态
	@RequestMapping(value = "delState")
	public String delState(int id, Model model) {
		equipmentInfoService.delState(id);
		return "redirect:/equipmentInfo/rentAndAssign";
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
