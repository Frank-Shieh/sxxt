package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.Major;

public interface MajorService {
	int addMajor(Major major);

	int editMajor(Major major);

	Major findById(int id);

	List<Major> findAll();

	List<Major> findBySchoolId(int id);

	int delMajor(int id);
}
