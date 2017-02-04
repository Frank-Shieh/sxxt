package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.ClassTeacherRelationship;

public interface AllocateClassService {
	int addRelationship(int classId, String[] teacherCode);

	int editRelationship(int classId, String[] teacherCode);

	ClassTeacherRelationship findById(int id);

	List<ClassTeacherRelationship> findByClassId(int id);

	List<ClassTeacherRelationship> findAll();

	int delRelationship(int id);
}
