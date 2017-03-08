package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.EducationManagerDao;
import sxxt.entity.EducationManager;
import sxxt.service.interfaces.EducationManagerService;

@Service
public class EducationManagerServiceImpl implements EducationManagerService {
	@Autowired
	private EducationManagerDao EducationManagerDao;

	@Override
	public int addEducationManager(EducationManager s) {
		// TODO Auto-generated method stub
		int result = EducationManagerDao.addEducationManager(s);
		return result;
	}

	@Override
	public int editEducationManager(EducationManager s) {
		// TODO Auto-generated method stub
		int result = EducationManagerDao.editEducationManager(s);
		return result;
	}

	@Override
	public List<EducationManager> findAll() {
		// TODO Auto-generated method stub
		List<EducationManager> result = EducationManagerDao.findAll();
		return result;
	}

	@Override
	public EducationManager findById(int id) {
		// TODO Auto-generated method stub
		EducationManager result = EducationManagerDao.findById(id);
		return result;
	}

	@Override
	public int delEducationManager(int id) {
		// TODO Auto-generated method stub
		int result = EducationManagerDao.delEducationManager(id);
		return result;
	}

	@Override
	public List<EducationManager> findByCompanyId(int id) {
		List<EducationManager> result = EducationManagerDao.findByCompanyId(id);
		return result;
	}

	@Override
	public EducationManager findByCode(String code) {
		// TODO Auto-generated method stub
		EducationManager result = EducationManagerDao.findByCode(code);
		return result;
	}
	@Override
	public int updatePassword(String code, String password) {
		// TODO Auto-generated method stub
		int result = EducationManagerDao.updatePassword(code,password);
		return result;
	}
}
