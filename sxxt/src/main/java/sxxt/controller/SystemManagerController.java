package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sxxt.entity.SystemManager;
import sxxt.service.interfaces.SystemManagerService;

@Controller
@RequestMapping(value = "/systemManager")
public class SystemManagerController {
	@Autowired
	private SystemManagerService systemManagerService;

	// 请求跳转到系统管理员信息列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<SystemManager> result = systemManagerService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无系统管理员信息");
		} else {
			model.addAttribute("result", result);
		}

		return "SystemManagerManage/listSystemManager";
	}

	// 请求跳转到添加系统管理员信息
	@RequestMapping(value = "add")
	public String add(Model model) {

		return "SystemManagerManage/addSystemManager";
	}

	// 请求跳转到添加系统管理员信息
	@RequestMapping(value = "doAdd")
	public String doAdd(SystemManager systemManager, Model model) {
		System.out.println(systemManager);
		systemManagerService.addSystemManager(systemManager);
		return "redirect:/systemManager/list";
	}

	// 请求跳转到查看系统管理员信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		SystemManager result = systemManagerService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "SystemManagerManage/viewSystemManager";
	}

	// 请求跳转到修改系统管理员信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		SystemManager systemManager = systemManagerService.findById(id);
		model.addAttribute("result", systemManager);

		return "SystemManagerManage/editSystemManager";
	}

	// 请求跳转到添加系统管理员信息
	@RequestMapping(value = "doEdit")
	public String doEdit(SystemManager systemManager, Model model) {
		System.out.println(systemManager);
		systemManagerService.editSystemManager(systemManager);
		return "redirect:/systemManager/list";
	}

	// 请求跳转到删除系统管理员信息
	@RequestMapping(value = "delete")
	public String delSystemManager(int id, Model model) {
		systemManagerService.delSystemManger(id);
		return "redirect:/systemManager/list";
	}
}
