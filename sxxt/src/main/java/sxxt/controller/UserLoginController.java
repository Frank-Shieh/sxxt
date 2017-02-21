package sxxt.controller;

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

import sxxt.entity.SchoolTeacher;
import sxxt.service.interfaces.SchoolTeacherService;
import sxxt.service.interfaces.StudentService;

@Controller

public class UserLoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;
	@Autowired
	private SchoolTeacherService schoolTeacherService;


	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest req) {
		return "/login/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(String code, String password,int role, HttpSession httpSession, Model model) {
		String errorMsg = "身份验证不通过,账号不合法或密码不正确!";
		try {
			

				switch (role) {
				case 1:
					SchoolTeacher s=schoolTeacherService.findByCode(code);
					if(s.getPassword().equals(password)){
						httpSession.setAttribute("user", s);
						httpSession.setAttribute("myheader", "../PowerManage/header.jsp");
						return "redirect:/class/list";
					}
					else{
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
	
	
	@RequestMapping(value="/logout", method={RequestMethod.GET})
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
