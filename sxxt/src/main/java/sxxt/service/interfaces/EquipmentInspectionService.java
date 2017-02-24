package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.EquipmentInspection;

public interface EquipmentInspectionService {
	int addEquipmentInspection(EquipmentInspection equipmentInspection);

	int editEquipmentInspection(EquipmentInspection equipmentInspection);

	EquipmentInspection findById(int id);

	List<EquipmentInspection> findByEquipmentInfoId(int id);

	List<EquipmentInspection> findAll();

	int delEquipmentInspection(int id);
}
