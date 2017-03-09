package sxxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.TeacherComment;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.TeacherCommentService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/teacherComment")
public class TeacherCommentController {
	@Autowired
	private TeacherCommentService teacherCommentService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;

	// 请求跳转到教师评价列表
	@RequestMapping(value = "list")
	public String list(int id, Model model) {
		List<TeacherComment> result = teacherCommentService.findByClassId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无教师评价信息");
		} else {
			model.addAttribute("result", result);
		}
		return "TeacherCommentManage/listTeacherComment";
	}

	// 请求跳转到教师评价列表
	@RequestMapping(value = "listAll")
	public String listAll(Model model) {
		List<TeacherComment> result = teacherCommentService.findAll();
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无教师评价信息");
		} else {
			model.addAttribute("result", result);
		}
		return "TeacherCommentManage/listAll";
	}

	// 请求跳转到教师评价列表
	@RequestMapping(value = "listByStudent")
	public String listByStudent(HttpSession httpSession, int id, Model model) {
		List<TeacherComment> result = teacherCommentService.findByStudentId(id);
		if (result.size() == 0) {
			model.addAttribute("errorMsg", "暂无教师评价信息");
		} else {
			model.addAttribute("result", result);
			model.addAttribute("user", httpSession.getAttribute("user"));
		}
		return "TeacherCommentManage/listByStudent";
	}

	// 请求跳转到添加教师评价信息
	@RequestMapping(value = "add")
	public String add(HttpSession httpSession, Model model) {

		model.addAttribute("user", httpSession.getAttribute("user"));

		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findAll();
		String jsonTrainningTeacher = JSON.toJSONString(trainningTeacherList);
		JSONArray jsonArrayTrainningTeacher = JSON.parseArray(jsonTrainningTeacher);
		model.addAttribute("trainningTeacherList", jsonArrayTrainningTeacher);

		return "TeacherCommentManage/addTeacherComment";
	}

	// 请求跳转到添加教师评价信息
	@RequestMapping(value = "doAdd")
	public String doAdd(TeacherComment teacherComment) {
		teacherCommentService.addTeacherComment(teacherComment);
		return "redirect:/teacherComment/listByStudent?id=" + teacherComment.getStudent().getId();
	}

	// 请求跳转到添加教师评价信息
	@RequestMapping(value = "edit")
	public String eidt(HttpSession httpSession, int id, Model model) {
		TeacherComment t = teacherCommentService.findById(id);
		model.addAttribute("result", t);
		model.addAttribute("user", httpSession.getAttribute("user"));
		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findAll();
		String jsonTrainningTeacher = JSON.toJSONString(trainningTeacherList);
		JSONArray jsonArrayTrainningTeacher = JSON.parseArray(jsonTrainningTeacher);
		model.addAttribute("trainningTeacherList", jsonArrayTrainningTeacher);

		return "TeacherCommentManage/editTeacherComment";
	}

	// 请求跳转到修改教师评价信息
	@RequestMapping(value = "doEdit")
	public String doEdit(TeacherComment teacherComment, Model model) {
		teacherCommentService.editTeacherComment(teacherComment);
		return "redirect:/teacherComment/listByStudent?id=" + teacherComment.getStudent().getId();
	}

	// 请求跳转到查看学生成绩信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		TeacherComment result = teacherCommentService.findById(id);
		model.addAttribute("result", result);
		return "TeacherCommentManage/viewTeacherComment";
	}
	@RequestMapping(value = "viewByStudent")
	public String viewByStudent(HttpSession httpSession,int id, Model model) {
		TeacherComment result = teacherCommentService.findById(id);
		model.addAttribute("user", httpSession.getAttribute("user"));
		model.addAttribute("result", result);
		return "TeacherCommentManage/viewByStudent";
	}
	@RequestMapping(value = "delete/{id}/{student}")
	public String delTeacherComment(@PathVariable("id") int id, @PathVariable("student") int student) {
		teacherCommentService.delTeacherComment(id);
		return "redirect:/teacherComment/listByStudent?id=" + student;

	}
}
