package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.dto.reponseDto;
import sxxt.entity.EquipmentInfo;
import sxxt.entity.EquipmentInspection;
import sxxt.entity.Site;
import sxxt.service.interfaces.EquipmentInfoService;
import sxxt.service.interfaces.EquipmentInspectionService;
import sxxt.service.interfaces.SiteService;

@Controller
@RequestMapping(value = "/equipmentInspection")
public class EquipmentInspectionController {
	@Autowired
	private SiteService siteService;
	@Autowired
	private EquipmentInfoService equipmentInfoService;
	@Autowired
	private EquipmentInspectionService equipmentInspectionService;

	// 请求跳转到场地信息列表
	@RequestMapping(value = "list/{id}")
	public String list(@PathVariable("id") int id, Model model) {
		List<EquipmentInspection> result = equipmentInspectionService.findByEquipmentInfoId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无相关设备年检信息");
		} else {
			model.addAttribute("result", result);
		}
		return "equipmentInspectionManage/listEquipmentInspection";
	}

	// 请求跳转到添加场地设备年检信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<Site> siteList = siteService.findAll();
		String jsonSite = JSON.toJSONString(siteList);
		JSONArray jsonArraySite = JSON.parseArray(jsonSite);
		model.addAttribute("siteList", jsonArraySite);

		List<EquipmentInfo> equipmentInfoList = equipmentInfoService.findBySiteId(siteList.get(0).getId());
		String jsonEquipmentInfo = JSON.toJSONString(equipmentInfoList);
		JSONArray jsonArrayEquipmentInfo = JSON.parseArray(jsonEquipmentInfo);
		model.addAttribute("equipmentInfoList", jsonArrayEquipmentInfo);

		return "equipmentInspectionManage/addEquipmentInspection";
	}

	@RequestMapping(value = "doAdd")
	public String doAdd(EquipmentInspection equipmentInspection, Model model) {
		equipmentInspectionService.addEquipmentInspection(equipmentInspection);
		return "redirect:/equipmentInspection/list/" + equipmentInspection.getEquipmentInfo().getId();
	}

	// 请求跳转到查看场地设备年检信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		EquipmentInspection e = equipmentInspectionService.findById(id);
		model.addAttribute("result", e);
		return "equipmentInspectionManage/viewEquipmentInspection";
	}

	// 请求跳转到修改场地设备年检信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		EquipmentInspection e = equipmentInspectionService.findById(id);
		model.addAttribute("result", e);

		List<Site> siteList = siteService.findAll();
		String jsonSite = JSON.toJSONString(siteList);
		JSONArray jsonArraySite = JSON.parseArray(jsonSite);
		model.addAttribute("siteList", jsonArraySite);

		List<EquipmentInfo> equipmentInfoList = equipmentInfoService.findBySiteId(siteList.get(0).getId());
		String jsonEquipmentInfo = JSON.toJSONString(equipmentInfoList);
		JSONArray jsonArrayEquipmentInfo = JSON.parseArray(jsonEquipmentInfo);
		model.addAttribute("equipmentInfoList", jsonArrayEquipmentInfo);

		return "equipmentInspectionManage/editEquipmentInspection";
	}

	// 请求跳转到修改场地设备年检信息
	@RequestMapping(value = "doEdit")
	public String doEdit(EquipmentInspection equipmentInspection, Model model) {
		System.out.println(equipmentInspection);
		equipmentInspectionService.editEquipmentInspection(equipmentInspection);
		return "redirect:/equipmentInspection/list/" + equipmentInspection.getEquipmentInfo().getId();
	}

	// 请求跳转到删除场地设备信息
	@RequestMapping(value = "delete/{id}/{eid}")
	public String delEquipmentInspection(@PathVariable("id") int id, @PathVariable("eid") int eid, Model model) {
		equipmentInspectionService.delEquipmentInspection(id);
		return "redirect:/equipmentInspection/list/" + eid;
	}

	// 请求查找新的设备列表
	@RequestMapping(value = "findBySiteId")
	public @ResponseBody reponseDto findBySiteId(int id, Model model) {
		reponseDto reponseDto = new reponseDto();

		List<EquipmentInfo> equipmentInfoList = equipmentInfoService.findBySiteId(id);
		if (equipmentInfoList != null && equipmentInfoList.size() > 0) {
			String jsonEquipmentInfo = JSON.toJSONString(equipmentInfoList);
			JSONArray jsonArrayEquipmentInfo = JSON.parseArray(jsonEquipmentInfo);
			reponseDto.setObject(jsonArrayEquipmentInfo);
			reponseDto.setLength(equipmentInfoList.size());
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}

		return reponseDto;
	}
}
