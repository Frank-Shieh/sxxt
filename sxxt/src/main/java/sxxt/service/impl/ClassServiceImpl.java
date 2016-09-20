package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.ClassDao;
import sxxt.entity.Class;
import sxxt.service.interfaces.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;

	@Override
	public int addClass(Class classId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editClass(Class classId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class> findAll() {
		// TODO Auto-generated method stub
		List<Class> result = classDao.findAll();
		return result;
	}

	@Override
	public int delClass(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
