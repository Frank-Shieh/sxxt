package sxxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sxxt.dto.reponseDto;
import sxxt.entity.School;
import sxxt.service.interfaces.SchoolService;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	// 请求添加学校
	@RequestMapping(value = "add")
	public @ResponseBody reponseDto add(String name, Model model) {
		reponseDto reponseDto = new reponseDto();
		School school = new School();
		school.setName(name);
		int result = schoolService.addSchool(school);
		if (result == 1) {
			reponseDto.setObject(school);
			reponseDto.setLength(1);
		} else {
			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}
		return reponseDto;

	}
}
