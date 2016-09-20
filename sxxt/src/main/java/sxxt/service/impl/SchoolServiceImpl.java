package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.SchoolDao;
import sxxt.entity.School;
import sxxt.service.interfaces.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public int addSchool(School school) {
		// TODO Auto-generated method stub
		int result = schoolDao.addSchool(school);
		return result;
	}

	@Override
	public int editSchool(School school) {
		// TODO Auto-generated method stub
		int result = schoolDao.editSchool(school);
		return result;
	}

	@Override
	public School findById(int id) {
		// TODO Auto-generated method stub
		School result = schoolDao.findById(id);
		return result;
	}

	@Override
	public List<School> findAll() {
		// TODO Auto-generated method stub
		List<School> result = schoolDao.findAll();
		return result;
	}

	@Override
	public int delSchool(int id) {
		// TODO Auto-generated method stub
		int result = schoolDao.delSchool(id);
		return result;
	}

}
