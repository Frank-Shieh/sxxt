package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.EquipmentManagerDao;
import sxxt.entity.EquipmentManager;
import sxxt.service.interfaces.EquipmentManagerService;

@Service
public class EquipmentManagerServiceImpl implements EquipmentManagerService {
	@Autowired
	private EquipmentManagerDao EquipmentManagerDao;

	@Override
	public int addEquipmentManager(EquipmentManager s) {
		// TODO Auto-generated method stub
		int result = EquipmentManagerDao.addEquipmentManager(s);
		return result;
	}

	@Override
	public int editEquipmentManager(EquipmentManager s) {
		// TODO Auto-generated method stub
		int result = EquipmentManagerDao.editEquipmentManager(s);
		return result;
	}

	@Override
	public List<EquipmentManager> findAll() {
		// TODO Auto-generated method stub
		List<EquipmentManager> result = EquipmentManagerDao.findAll();
		return result;
	}

	@Override
	public EquipmentManager findById(int id) {
		// TODO Auto-generated method stub
		EquipmentManager result = EquipmentManagerDao.findById(id);
		return result;
	}

	@Override
	public int delEquipmentManager(int id) {
		// TODO Auto-generated method stub
		int result = EquipmentManagerDao.delEquipmentManager(id);
		return result;
	}

	@Override
	public List<EquipmentManager> findByCompanyId(int id) {
		List<EquipmentManager> result = EquipmentManagerDao.findByCompanyId(id);
		return result;
	}

	@Override
	public EquipmentManager findByCode(String code) {
		// TODO Auto-generated method stub
		EquipmentManager result = EquipmentManagerDao.findByCode(code);
		return result;
	}

}
