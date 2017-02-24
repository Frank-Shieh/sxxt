package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.EquipmentInspectionDao;
import sxxt.entity.EquipmentInspection;
import sxxt.service.interfaces.EquipmentInspectionService;

@Service
public class EquipmentInspectionServiceImpl implements EquipmentInspectionService {
	@Autowired
	private EquipmentInspectionDao equipmentInspectionDao;

	@Override
	public int addEquipmentInspection(EquipmentInspection equipmentInspection) {
		// TODO Auto-generated method stub
		int result = equipmentInspectionDao.addEquipmentInspection(equipmentInspection);
		return result;
	}

	@Override
	public int editEquipmentInspection(EquipmentInspection equipmentInspection) {
		// TODO Auto-generated method stub
		int result = equipmentInspectionDao.editEquipmentInspection(equipmentInspection);
		return result;
	}

	@Override
	public EquipmentInspection findById(int id) {
		// TODO Auto-generated method stub
		EquipmentInspection result = equipmentInspectionDao.findById(id);
		return result;
	}

	@Override
	public List<EquipmentInspection> findByEquipmentInfoId(int id) {
		// TODO Auto-generated method stub
		List<EquipmentInspection> result = equipmentInspectionDao.findByEquipmentInfoId(id);
		return result;
	}

	@Override
	public List<EquipmentInspection> findAll() {
		// TODO Auto-generated method stub
		List<EquipmentInspection> result = equipmentInspectionDao.findAll();
		return result;
	}

	@Override
	public int delEquipmentInspection(int id) {
		// TODO Auto-generated method stub
		int result = equipmentInspectionDao.delEquipmentInspection(id);
		return result;
	}

}
