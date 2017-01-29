package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.TrainningTeacherDao;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.TrainningTeacherService;

@Service
public class TrainningTeacherServiceImpl implements TrainningTeacherService {
	@Autowired
	private TrainningTeacherDao TrainningTeacherDao;

	@Override
	public int addTrainningTeacher(TrainningTeacher s) {
		// TODO Auto-generated method stub
		int result = TrainningTeacherDao.addTrainningTeacher(s);
		return result;
	}

	@Override
	public int editTrainningTeacher(TrainningTeacher s) {
		// TODO Auto-generated method stub
		int result = TrainningTeacherDao.editTrainningTeacher(s);
		return result;
	}

	@Override
	public List<TrainningTeacher> findAll() {
		// TODO Auto-generated method stub
		List<TrainningTeacher> result = TrainningTeacherDao.findAll();
		return result;
	}

	@Override
	public TrainningTeacher findById(int id) {
		// TODO Auto-generated method stub
		TrainningTeacher result = TrainningTeacherDao.findById(id);
		return result;
	}

	@Override
	public TrainningTeacher findByCode(String code) {
		// TODO Auto-generated method stub
		TrainningTeacher result = TrainningTeacherDao.findByCode(code);
		return result;
	}

	@Override
	public int delTrainningTeacher(int id) {
		// TODO Auto-generated method stub
		int result = TrainningTeacherDao.delTrainningTeacher(id);
		return result;
	}

	@Override
	public List<TrainningTeacher> findByCompanyId(int id) {
		// TODO Auto-generated method stub
		List<TrainningTeacher> result = TrainningTeacherDao.findByCompanyId(id);
		return result;
	}
}
