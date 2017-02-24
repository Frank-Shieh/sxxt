package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.EquipmentInfoDao;
import sxxt.entity.EquipmentInfo;
import sxxt.service.interfaces.EquipmentInfoService;

@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService {
	@Autowired
	public EquipmentInfoDao equipmentInfoDao;

	@Override
	public int addEquipmentInfo(EquipmentInfo equipmentInfo) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.addEquipmentInfo(equipmentInfo);
		return result;
	}

	@Override
	public int editEquipmentInfo(EquipmentInfo equipmentInfo) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.editEquipmentInfo(equipmentInfo);
		return result;
	}

	@Override
	public int editRent(EquipmentInfo equipmentInfo) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.editRent(equipmentInfo);
		return result;
	}

	@Override
	public int editAssign(EquipmentInfo equipmentInfo) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.editAssign(equipmentInfo);
		return result;
	}

	@Override
	public EquipmentInfo findById(int id) {
		// TODO Auto-generated method stub
		EquipmentInfo result = equipmentInfoDao.findById(id);
		return result;
	}

	@Override
	public List<EquipmentInfo> findAll() {
		// TODO Auto-generated method stub
		List<EquipmentInfo> result = equipmentInfoDao.findAll();
		return result;
	}

	@Override
	public int delEquipmentInfo(int id) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.delEquipmentInfo(id);
		return result;
	}

	@Override
	public int delState(int id) {
		// TODO Auto-generated method stub
		int result = equipmentInfoDao.delState(id);
		return result;
	}

}
