package sxxt.service.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import sxxt.entity.TaskTeacherRelationship;
import sxxt.entity.TeachingTask;

public interface TeachingTaskService {
	@Transactional
	int addTeachingTask(TeachingTask teachingTask);

	int editTeachingTask(TeachingTask teachingTask);

	List<TeachingTask> findAll();

	TeachingTask findById(int id);

	@Transactional
	int delTeachingTask(int id);

	/**
	 * 下面是操作实训教师和教学任务之间的表即task_teacher_relationship
	 */

	int addTaskTeacher(@Param("taskId") int taskId, String[] teacherCode);

	List<TaskTeacherRelationship> findByTaskId(@Param("taskId") int taskId);

	int editTaskTeacher(int id, String[] teacherCode);

	int delTasktTeacher(int id);

}
