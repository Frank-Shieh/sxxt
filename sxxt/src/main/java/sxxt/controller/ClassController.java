package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sxxt.entity.Class;
import sxxt.entity.Student;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.StudentService;

@Controller
@RequestMapping(value = "/class")
public class ClassController {
	@Autowired
	private ClassService classService;

	// 请求获取到列表页面
		@RequestMapping(value = "list")
		public String list(Model model) {
			try {
				List<Class> result = classService.findAll();
				model.addAttribute("result", result);
				return "studentManage/listClass";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("errorMsg", "查找班级信息失败");
				return "studentManage/listClass";
			}
		}
		// 请求添加班级
				@RequestMapping(value = "add")
				public String add(String name,Model model) {
					try {
						Class classId = new Class();
						classId.setName(name);
						int result = classService.addClass(classId);
						model.addAttribute("result", result);
						return "studentManage/listClass";
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						model.addAttribute("errorMsg", "查找班级信息失败");
						return "studentManage/listClass";
					}
				}
}
