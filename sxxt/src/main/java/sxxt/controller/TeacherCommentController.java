package sxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import sxxt.entity.Class;
import sxxt.entity.Major;
import sxxt.entity.School;
import sxxt.entity.Student;
import sxxt.entity.TeacherComment;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.ClassService;
import sxxt.service.interfaces.MajorService;
import sxxt.service.interfaces.SchoolService;
import sxxt.service.interfaces.StudentService;
import sxxt.service.interfaces.TeacherCommentService;
import sxxt.service.interfaces.TrainningTeacherService;

@Controller
@RequestMapping(value = "/teacherComment")
public class TeacherCommentController {
	@Autowired
	private TeacherCommentService teacherCommentService;
	@Autowired
	private TrainningTeacherService trainningTeacherService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentService;

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

	// 请求跳转到添加教师评价信息
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

		List<Student> studentList = studentService.findByClassId(classList.get(0).getId());
		String jsonStudent = JSON.toJSONString(studentList);
		JSONArray jsonArrayStudent = JSON.parseArray(jsonStudent);
		model.addAttribute("studentList", jsonArrayStudent);

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
		return "redirect:/teacherComment/list?id=" + teacherComment.getClassId().getId();
	}

	// 请求跳转到添加教师评价信息
	@RequestMapping(value = "edit")
	public String eidt(int id, Model model) {
		TeacherComment t = teacherCommentService.findById(id);
		model.addAttribute("result", t);

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

		List<Student> studentList = studentService.findByClassId(classList.get(0).getId());
		String jsonStudent = JSON.toJSONString(studentList);
		JSONArray jsonArrayStudent = JSON.parseArray(jsonStudent);
		model.addAttribute("studentList", jsonArrayStudent);

		List<TrainningTeacher> trainningTeacherList = trainningTeacherService.findAll();
		String jsonTrainningTeacher = JSON.toJSONString(trainningTeacherList);
		JSONArray jsonArrayTrainningTeacher = JSON.parseArray(jsonTrainningTeacher);
		model.addAttribute("trainningTeacherList", jsonArrayTrainningTeacher);

		return "TeacherCommentManage/editTeacherComment";
	}

	// 请求跳转到修改教师评价信息
	@RequestMapping(value = "doEdit")
	public String doEdit(TeacherComment teacherComment, Model model) {
		System.out.println(teacherComment);
		teacherCommentService.editTeacherComment(teacherComment);
		return "redirect:/teacherComment/list?id=" + teacherComment.getClassId().getId();
	}

	// 请求跳转到查看学生成绩信息
	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		TeacherComment result = teacherCommentService.findById(id);
		model.addAttribute("result", result);
		return "TeacherCommentManage/viewTeacherComment";
	}
}
