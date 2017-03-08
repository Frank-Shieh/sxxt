package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.EquipmentManager;

public interface EquipmentManagerDao {
	int addEquipmentManager(EquipmentManager s);

	int editEquipmentManager(EquipmentManager s);

	List<EquipmentManager> findAll();

	List<EquipmentManager> findByCompanyId(int id);

	EquipmentManager findById(int id);

	EquipmentManager findByCode(String code);
	int updatePassword(@Param("code")String code,@Param("password")String password);

	int delEquipmentManager(int id);
}
