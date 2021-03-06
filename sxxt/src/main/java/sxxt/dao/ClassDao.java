package sxxt.dao;

import java.util.List;

import sxxt.entity.Class;

public interface ClassDao {
	int addClass(Class classId);

	int editClass(Class classId);

	Class findById(int id);

	List<Class> findIdAndName();

	List<Class> findAll();

	List<Class> findByMajorId(int id);

	int delClass(int id);
}
