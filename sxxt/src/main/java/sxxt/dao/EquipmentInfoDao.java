package sxxt.dao;

import java.util.List;

import sxxt.entity.EquipmentInfo;

public interface EquipmentInfoDao {
	int addEquipmentInfo(EquipmentInfo equipmentInfo);

	int editEquipmentInfo(EquipmentInfo equipmentInfo);

	int editRent(EquipmentInfo equipmentInfo);
	
	int editAssign(EquipmentInfo equipmentInfo);
	
	EquipmentInfo findById(int id);

	List<EquipmentInfo> findAll();

	int delEquipmentInfo(int id);
	
	int delState(int id);
}
