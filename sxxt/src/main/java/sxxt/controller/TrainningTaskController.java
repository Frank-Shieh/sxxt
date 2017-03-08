package sxxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Class;
import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.entity.TaskClassRelationship;
import sxxt.entity.TrainningTask;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.TrainningTaskService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/trainningTask")
public class TrainningTaskController {
	@Autowired
	TrainningTaskService trainningTaskService;
	@Autowired
	private ClassService classService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;

	// 请求跳转到实训教学任务列表
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<TrainningTask> result = trainningTaskService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无实训任务信息");
		} else {
			model.addAttribute("result", result);
		}
		return "TrainningTaskManage/listTrainningTask";
	}

	@RequestMapping(value = "listOnly")
	public String listOnly(int id, Model model) {
		List<TrainningTask> result = trainningTaskService.findByClassId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无实训任务信息");
		} else {
			model.addAttribute("result", result);
		}

		return "TrainningTaskManage/listOnly";
	}

	// 请求跳转到查看教学任务信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		TrainningTask result = trainningTaskService.findById(id);
		model.addAttribute("result", result);
		List<TaskClassRelationship> relationship = trainningTaskService.findByTaskId(id);
		model.addAttribute("relationship", relationship.get(0));
		return "TrainningTaskManage/viewTrainningTask";
	}
	// 请求跳转到查看教学任务信息
		@RequestMapping(value = "viewOnly")
		public String viewOnly(HttpSession httpSession,int id, Model model) {
			TrainningTask result = trainningTaskService.findById(id);
			model.addAttribute("result", result);
			model.addAttribute("user", httpSession.getAttribute("user"));
			List<TaskClassRelationship> relationship = trainningTaskService.findByTaskId(id);
			model.addAttribute("relationship", relationship.get(0));
			return "TrainningTaskManage/viewOnly";
		}
	// 请求跳转到添加教学任务信息
	@RequestMapping(value = "add")
	public String add(Model model) {
		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		List<Major> majorList = majorService.findBySchoolId(schoolList.get(0).getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);

		List<Class> classList = classService.findByMajorId(majorList.get(0).getId());
		String jsonClass = JSON.toJSONString(classList);
		JSONArray jsonArrayClass = JSON.parseArray(jsonClass);
		model.addAttribute("classList", jsonArrayClass);

		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findAll();
		String jsonTrainningTeacher = JSON.toJSONString(trainningTeacherList);
		JSONArray jsonArrayTrainningTeacher = JSON.parseArray(jsonTrainningTeacher);
		model.addAttribute("trainningTeacherList", jsonArrayTrainningTeacher);

		return "TrainningTaskManage/addTrainningTask";
	}

	@RequestMapping(value = "doAdd")
	public String doAdd(TrainningTask trainningTask, int classId) {
		trainningTaskService.addTrainningTask(trainningTask);
		trainningTaskService.addTaskClass(trainningTask.getId(), classId);
		return "redirect:/trainningTask/list";
	}

	// 请求跳转到修改教学任务信息
	@RequestMapping(value = "edit")
	public String edit(int id, Model model) {
		TrainningTask trainningTask = trainningTaskService.findById(id);
		model.addAttribute("trainningTask", trainningTask);
		List<TaskClassRelationship> relationship = trainningTaskService.findByTaskId(id);
		model.addAttribute("relationship", relationship.get(0));

		List<School> schoolList = schoolService.findAll();
		String jsonSchool = JSON.toJSONString(schoolList);
		JSONArray jsonArraySchool = JSON.parseArray(jsonSchool);
		model.addAttribute("schoolList", jsonArraySchool);

		List<Major> majorList = majorService.findBySchoolId(schoolList.get(0).getId());
		String jsonMajor = JSON.toJSONString(majorList);
		JSONArray jsonArrayMajor = JSON.parseArray(jsonMajor);
		model.addAttribute("majorList", jsonArrayMajor);

		List<Class> classList = classService.findByMajorId(majorList.get(0).getId());
		String jsonClass = JSON.toJSONString(classList);
		JSONArray jsonArrayClass = JSON.parseArray(jsonClass);
		model.addAttribute("classList", jsonArrayClass);

		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findAll();
		String jsonTrainningTeacher = JSON.toJSONString(trainningTeacherList);
		JSONArray jsonArrayTrainningTeacher = JSON.parseArray(jsonTrainningTeacher);
		model.addAttribute("trainningTeacherList", jsonArrayTrainningTeacher);

		return "TrainningTaskManage/editTrainningTask";
	}

	@RequestMapping(value = "doEdit")
	public String doEdit(TrainningTask trainningTask, int classId) {
		trainningTaskService.editTrainningTask(trainningTask);
		trainningTaskService.editTaskClass(trainningTask.getId(), classId);
		return "redirect:/trainningTask/list";
	}

	// 请求跳转到删除单个实训教师信息
	@RequestMapping(value = "delete")
	public String delTrainningTask(int id, Model model) {
		trainningTaskService.delTrainningTask(id);
		return "redirect:/trainningTask/list";
	}
}
