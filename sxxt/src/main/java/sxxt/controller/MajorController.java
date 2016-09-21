package sxxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sxxt.dto.reponseDto;
import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.service.interfaces.MajorService;

@Controller
@RequestMapping(value = "/major")
public class MajorController {
	@Autowired
	private MajorService majorService;

	// 请求添加专业
	@RequestMapping(value = "add")
	public @ResponseBody reponseDto add(int schoolId, String name, Model model) {
		reponseDto reponseDto = new reponseDto();

		Major major = new Major();
		major.setName(name);
		School school = new School();
		school.setId(schoolId);
		major.setSchool(school);
		int result = majorService.addMajor(major);
		if (result == 1) {
			reponseDto.setObject(major);
			reponseDto.setLength(1);
		} else {

			reponseDto.setObject(null);
			reponseDto.setLength(0);
		}
		return reponseDto;

	}
}
