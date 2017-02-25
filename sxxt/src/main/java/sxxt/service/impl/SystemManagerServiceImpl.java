package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.SystemManagerDao;
import sxxt.entity.SystemManager;
import sxxt.service.interfaces.SystemManagerService;

@Service
public class SystemManagerServiceImpl implements SystemManagerService {
	@Autowired
	private SystemManagerDao systemManagerDao;

	@Override
	public int addSystemManager(SystemManager systemManager) {
		// TODO Auto-generated method stub
		int result = systemManagerDao.addSystemManager(systemManager);
		return result;
	}

	@Override
	public int editSystemManager(SystemManager systemManager) {
		// TODO Auto-generated method stub
		int result = systemManagerDao.editSystemManager(systemManager);
		return result;
	}

	@Override
	public SystemManager findById(int id) {
		// TODO Auto-generated method stub
		SystemManager result = systemManagerDao.findById(id);
		return result;
	}

	@Override
	public SystemManager findByCode(String code) {
		// TODO Auto-generated method stub
		SystemManager result = systemManagerDao.findByCode(code);
		return result;
	}

	@Override
	public List<SystemManager> findAll() {
		// TODO Auto-generated method stub
		List<SystemManager> result = systemManagerDao.findAll();
		return result;
	}

	@Override
	public int delSystemManger(int id) {
		// TODO Auto-generated method stub
		int result = systemManagerDao.delSystemManger(id);
		return result;
	}

}
