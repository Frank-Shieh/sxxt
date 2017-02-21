package sxxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sxxt.entity.EducationManager;
import sxxt.entity.EquipmentManager;
import sxxt.entity.SchoolTeacher;
import sxxt.entity.SiteManager;
import sxxt.entity.Student;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.EducationManagerService;
import sxxt.service.interfaces.EquipmentManagerService;
import sxxt.service.interfaces.SchoolTeacherService;
import sxxt.service.interfaces.SiteManagerService;
import sxxt.service.interfaces.StudentService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller

public class UserLoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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


	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest req) {

		List<String> roleList = new ArrayList<>();
		roleList.add(0, "学校教师");
		roleList.add(1, "学校学生");
		roleList.add(2, "教务主管");
		roleList.add(3, "设备管理员");
		roleList.add(4, "场地管理员");
		roleList.add(5, "培训教师");

		model.addAttribute("roleList", roleList);
		return "/login/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(String code, String password, int role, HttpSession httpSession, Model model) {
		String errorMsg = "身份验证不通过,账号不合法或密码不正确!";
		try {

			switch (role) {
			case 1: // 学校教师登陆
				SchoolTeacher schoolTeacher = schoolTeacherService.findByCode(code);
				if (schoolTeacher.getPassword().equals(password)) {
					httpSession.setAttribute("user", schoolTeacher);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			case 2: // 学生登陆
				Student student = studentService.findByCode(code);
				if (student.getPassword().equals(password)) {
					httpSession.setAttribute("user", student);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			case 3: // 教务主管登陆
				EducationManager educationManager = educationManagerService.findByCode(code);
				if (educationManager.getPassword().equals(password)) {
					httpSession.setAttribute("user", educationManager);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			case 4: // 设备管理员登陆
				EquipmentManager equipmentManager = equipmentManagerService.findByCode(code);
				if (equipmentManager.getPassword().equals(password)) {
					httpSession.setAttribute("user", equipmentManager);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			case 5: // 场地管理员登陆
				SiteManager siteManager = siteManagerService.findByCode(code);
				if (siteManager.getPassword().equals(password)) {
					httpSession.setAttribute("user", siteManager);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			case 6: // 培训教师登陆
				TrainningTeacher trainningTeacher = trainningTeacherService.findByCode(code);
				if (trainningTeacher.getPassword().equals(password)) {
					httpSession.setAttribute("user", trainningTeacher);
					httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
					return "redirect:/class/list";
				} else {
					model.addAttribute("errorMsg", errorMsg);
					return "forward:/login";
				}
			default:
				break;
			}

		} catch (Exception e) {
			logger.warn("登录异常: " + e.getMessage());
			/* errorMsg = "员工编号不合法或密码错误!"; */
			model.addAttribute("errorMsg", errorMsg);
		}

		model.addAttribute("errorMsg", errorMsg);
		return "forward:/login";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public void logout(HttpServletResponse response, HttpSession session) {
		try {
			session.removeAttribute("user");
			response.sendRedirect("/login");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/login";
	}
}
