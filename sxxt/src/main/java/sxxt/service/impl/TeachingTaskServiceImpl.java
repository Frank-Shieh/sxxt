package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.TeachingTaskDao;
import sxxt.dao.TrainningTeacherDao;
import sxxt.entity.TaskTeacherRelationship;
import sxxt.entity.TeachingTask;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.TeachingTaskService;

@Service
public class TeachingTaskServiceImpl implements TeachingTaskService {
	@Autowired
	TeachingTaskDao teachingTaskDao;
	@Autowired
	TrainningTeacherDao trainningTeacherDao;

	@Override
	public int addTeachingTask(TeachingTask teachingTask) {
		// TODO Auto-generated method stub
		int result = teachingTaskDao.addTeachingTask(teachingTask);
		return result;
	}

	@Override
	public int editTeachingTask(TeachingTask teachingTask) {
		// TODO Auto-generated method stub
		int result = teachingTaskDao.editTeachingTask(teachingTask);
		return result;
	}

	@Override
	public List<TeachingTask> findAll() {
		// TODO Auto-generated method stub
		List<TeachingTask> result = teachingTaskDao.findAll();
		return result;
	}

	@Override
	public TeachingTask findById(int id) {
		// TODO Auto-generated method stub
		TeachingTask result = teachingTaskDao.findById(id);
		return result;
	}

	@Override
	public int delTeachingTask(int id) {
		// TODO Auto-generated method stub
		int result = teachingTaskDao.delTeachingTask(id);
		return result;
	}

	@Override
	public int addTaskTeacher(int taskId, String[] teacherCode) {
		// TODO Auto-generated method stub
		int result = 0;
		for (int i = 0; i < teacherCode.length; i++) {
			TrainningTeacher trainningTeacher = trainningTeacherDao.findByCode(teacherCode[i]);
			result = teachingTaskDao.addTaskTeacher(taskId, trainningTeacher.getId());
		}
		return result;
	}

	@Override
	public List<TaskTeacherRelationship> findByTaskId(int taskId) {
		// TODO Auto-generated method stub
		List<TaskTeacherRelationship> result = teachingTaskDao.findByTaskId(taskId);
		return result;
	}

	@Override
	public int editTaskTeacher(int id, String[] teacherCode) {
		// TODO Auto-generated method stub
		int result = 0;
		teachingTaskDao.delTasktTeacher(id);
		for (int i = 0; i < teacherCode.length; i++) {
			TrainningTeacher trainningTeacher = trainningTeacherDao.findByCode(teacherCode[i]);
			result = teachingTaskDao.addTaskTeacher(id, trainningTeacher.getId());
		}
		return result;
	}

	@Override
	public int delTasktTeacher(int id) {
		// TODO Auto-generated method stub
		int result = teachingTaskDao.delTasktTeacher(id);
		return result;
	}

}
