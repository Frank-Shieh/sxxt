package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.ClassTeacherRelationship;

public interface AllocateClassDao {

	int addRelationship(@Param("classId") int classId,@Param("teacherId") int teacherId );

	int editRelationship(@Param("classId") int classId,@Param("teacherId") int teacherId );

	ClassTeacherRelationship findById(int id);

	List<ClassTeacherRelationship> findByClassId(int id);

	List<ClassTeacherRelationship> findAll();

	int delRelationship(int id);

}
