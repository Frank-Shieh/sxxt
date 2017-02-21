package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.EquipmentManager;

public interface EquipmentManagerService {
	int addEquipmentManager(EquipmentManager s);

	int editEquipmentManager(EquipmentManager s);

	List<EquipmentManager> findAll();

	List<EquipmentManager> findByCompanyId(int id);

	EquipmentManager findById(int id);

	EquipmentManager findByCode(String code);

	int delEquipmentManager(int id);
}
