package sxxt.dao;

import java.util.List;

import sxxt.entity.Major;

public interface MajorDao {

	int addMajor(Major major);

	int editMajor(Major major);

	Major findById(int id);

	List<Major> findAll();

	int delMajor(int id);

}
