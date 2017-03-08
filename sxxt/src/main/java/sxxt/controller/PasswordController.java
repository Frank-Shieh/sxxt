package sxxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sxxt.entity.EducationManager;
import sxxt.entity.EquipmentManager;
import sxxt.entity.SchoolTeacher;
import sxxt.entity.SiteManager;
import sxxt.entity.Student;
import sxxt.entity.SystemManager;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.EducationManagerService;
import sxxt.service.interfaces.EquipmentManagerService;
import sxxt.service.interfaces.SchoolTeacherService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.StudentService;
import sxxt.service.interfaces.SystemManagerService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller

public class PasswordController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private SchoolTeacherService schoolTeacherService;
	@Autowired
	private EducationManagerService educationManagerService;
	@Autowired
	private EquipmentManagerService equipmentManagerService;
	@Autowired
	private SiteManagerService siteManagerService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;
	@Autowired
	private SystemManagerService systemManagerService;

	@RequestMapping("/password")
	public String pswAlter(HttpSession httpSession, Model model) {
		model.addAttribute("user", httpSession.getAttribute("user"));

		String myheader = (String) httpSession.getAttribute("myheader");
		model.addAttribute("myheader", myheader);
		return "login/pswalter";
	}

	@RequestMapping("/password/altersave")
	public String save(HttpSession httpSession, String oldpsw, String code, String newpsw, Model model) {
		int result = 0;
		int role = (Integer) httpSession.getAttribute("role");
		switch (role) {
		case 1: // 学校教师登陆
			SchoolTeacher schoolTeacher = schoolTeacherService.findByCode(code);
			if (schoolTeacher.getPassword().equals(oldpsw)) {
				result = schoolTeacherService.updatePassword(code, newpsw);
			}
			break;
		case 2: // 学生登陆
			Student student = studentService.findByCode(code);
			if (student.getPassword().equals(oldpsw)) {
				result = studentService.updatePassword(code, newpsw);
			}
			break;
		case 3: // 教务主管登陆
			EducationManager educationManager = educationManagerService.findByCode(code);
			if (educationManager.getPassword().equals(oldpsw)) {
				result = educationManagerService.updatePassword(code, newpsw);
			}
			break;
		case 4: // 设备管理员登陆
			EquipmentManager equipmentManager = equipmentManagerService.findByCode(code);
			if (equipmentManager.getPassword().equals(oldpsw)) {
				result = equipmentManagerService.updatePassword(code, newpsw);
			}
			break;
		case 5: // 场地管理员登陆
			SiteManager siteManager = siteManagerService.findByCode(code);
			if (siteManager.getPassword().equals(oldpsw)) {
				result = siteManagerService.updatePassword(code, newpsw);
			}
			break;
		case 6: // 培训教师登陆
			TrainningTeacher trainningTeacher = trainningTeacherService.findByCode(code);
			if (trainningTeacher.getPassword().equals(oldpsw)) {
				result = trainningTeacherService.updatePassword(code, newpsw);
			}
			break;
		case 7: // 系统管理员登陆
			SystemManager systemManager = systemManagerService.findByCode(code);
			if (systemManager.getPassword().equals(oldpsw)) {
				result = systemManagerService.updatePassword(code, newpsw);
			}
			break;

		default:
			break;
		}

		if (result > 0)
			model.addAttribute("success", "1");
		else
			model.addAttribute("success", "0");
		return "redirect:/password";
	}
}
