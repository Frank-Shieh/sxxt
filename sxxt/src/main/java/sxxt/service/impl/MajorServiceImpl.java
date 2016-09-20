package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.MajorDao;
import sxxt.entity.Major;
import sxxt.service.interfaces.MajorService;
@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;

	@Override
	public int addMajor(Major major) {
		// TODO Auto-generated method stub
		int result = majorDao.addMajor(major);
		return result;
	}

	@Override
	public int editMajor(Major major) {
		// TODO Auto-generated method stub
		int result = majorDao.editMajor(major);
		return result;
	}

	@Override
	public Major findById(int id) {
		// TODO Auto-generated method stub
		Major result = majorDao.findById(id);
		return result;
	}

	@Override
	public List<Major> findAll() {
		// TODO Auto-generated method stub
		List<Major> result = majorDao.findAll();
		return result;
	}

	@Override
	public List<Major> findBySchoolId(int id) {
		// TODO Auto-generated method stub
		List<Major> result = majorDao.findBySchoolId(id);
		return result;
	}

	@Override
	public int delMajor(int id) {
		// TODO Auto-generated method stub
		int result = majorDao.delMajor(id);
		return result;
	}

}
