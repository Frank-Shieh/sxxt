package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.EducationManager;
import sxxt.entity.TaskTeacherRelationship;
import sxxt.entity.TeachingTask;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.EducationManagerService;
import sxxt.service.interfaces.TeachingTaskService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/teachingTask")
public class TeachingTaskController {
	@Autowired
	TeachingTaskService teachingTaskService;
	@Autowired
	EducationManagerService educationManagerService;
	@Autowired
	TrainningTeacherService trainningTeacherService;

	// 请求跳转到实训教学任务列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<TeachingTask> result = teachingTaskService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无教学任务信息");
		} else {
			model.addAttribute("result", result);
		}

		return "TeachingTaskManage/listTeachingTask";
	}

	// 请求跳转到查看教学任务信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		TeachingTask result = teachingTaskService.findById(id);
		System.out.println(result);
		model.addAttribute("result", result);
		return "TeachingTaskManage/viewTeachingTask";
	}

	// 请求跳转到添加教学任务信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<EducationManager> educationManagerList = educationManagerService.findAll();
		String jsonSchool = JSON.toJSONString(educationManagerList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("educationManagerList", jsonArraySchool);

		return "TeachingTaskManage/addTeachingTask";
	}

	@RequestMapping(value = "doAdd")
	public String doAdd(TeachingTask teachingTask, String[] trainningTeacherCode) {
		teachingTaskService.addTeachingTask(teachingTask);
		teachingTaskService.addTaskTeacher(teachingTask.getId(), trainningTeacherCode);
		return "redirect:/teachingTask/list";
	}

	// 请求跳转到修改教学任务信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		TeachingTask teachingTask = teachingTaskService.findById(id);
		model.addAttribute("teachingTask", teachingTask);

		List<EducationManager> educationManagerList = educationManagerService.findAll();
		String jsonSchool = JSON.toJSONString(educationManagerList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("educationManagerList", jsonArraySchool);

		List<TaskTeacherRelationship> trainningTeacherList = teachingTaskService.findByTaskId(id);
		jsonSchool = JSON.toJSONString(trainningTeacherList);
		jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("trainningTeacherList", jsonArraySchool);

		return "TeachingTaskManage/editTeachingTask";
	}

	@RequestMapping(value = "doEdit")
	public String doEdit(TeachingTask teachingTask, String[] trainningTeacherCode) {
		teachingTaskService.editTeachingTask(teachingTask);
		teachingTaskService.editTaskTeacher(teachingTask.getId(), trainningTeacherCode);
		return "redirect:/teachingTask/list";
	}

}
