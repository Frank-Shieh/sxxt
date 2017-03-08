package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.ClassDao;
import sxxt.dao.TrainningTaskDao;
import sxxt.entity.TaskClassRelationship;
import sxxt.entity.TrainningTask;
import sxxt.service.interfaces.TrainningTaskService;

@Service
public class TrainningTaskServiceImpl implements TrainningTaskService {
	@Autowired
	TrainningTaskDao TrainningTaskDao;
	@Autowired
	ClassDao classDao;

	@Override
	public int addTrainningTask(TrainningTask TrainningTask) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.addTrainningTask(TrainningTask);
		return result;
	}

	@Override
	public int editTrainningTask(TrainningTask TrainningTask) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.editTrainningTask(TrainningTask);
		return result;
	}

	@Override
	public List<TrainningTask> findAll() {
		// TODO Auto-generated method stub
		List<TrainningTask> result = TrainningTaskDao.findAll();
		return result;
	}

	@Override
	public TrainningTask findById(int id) {
		// TODO Auto-generated method stub
		TrainningTask result = TrainningTaskDao.findById(id);
		return result;
	}

	@Override
	public int delTrainningTask(int id) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.delTrainningTask(id);
		return result;
	}

	@Override
	public int addTaskClass(int taskId, int classId) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.addTaskClass(taskId, classId);
		return result;
	}

	@Override
	public List<TaskClassRelationship> findByTaskId(int taskId) {
		// TODO Auto-generated method stub
		List<TaskClassRelationship> result = TrainningTaskDao.findByTaskId(taskId);
		return result;
	}

	@Override
	public int editTaskClass(int id, int classId) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.editTaskClass(id, classId);
		return result;
	}

	@Override
	public int delTasktClass(int id) {
		// TODO Auto-generated method stub
		int result = TrainningTaskDao.delTasktClass(id);
		return result;
	}

	@Override
	public List<TrainningTask> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<TrainningTask> result = TrainningTaskDao.findByClassId(id);
		return result;
	}

}
