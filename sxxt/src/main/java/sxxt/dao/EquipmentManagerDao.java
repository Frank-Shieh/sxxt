package sxxt.dao;

import java.util.List;

import sxxt.entity.EquipmentManager;

public interface EquipmentManagerDao {
	int addEquipmentManager(EquipmentManager s);

	int editEquipmentManager(EquipmentManager s);

	List<EquipmentManager> findAll();

	List<EquipmentManager> findByCompanyId(int id);

	EquipmentManager findById(int id);

	int delEquipmentManager(int id);
}
