package sxxt.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.AllocateClassDao;
import sxxt.dao.TrainningTeacherDao;
import sxxt.entity.ClassTeacherRelationship;
import sxxt.entity.TrainningTeacher;
import sxxt.service.interfaces.AllocateClassService;

@Service
public class AllocateClassServiceImpl implements AllocateClassService {
	@Autowired
	AllocateClassDao allocateClassDao;
	@Autowired
	TrainningTeacherDao trainningTeacherDao;

	@Override
	public int addRelationship(int classId, String[] teacherCode) {
		// TODO Auto-generated method stub
		int result = 0;
		List<String> list = Arrays.asList(teacherCode);
		Set<String> set = new HashSet<String>(list);
		String[] code = (String[]) set.toArray(new String[0]);
		for (int i = 0; i < code.length; i++) {
			TrainningTeacher trainningTeacher = trainningTeacherDao.findByCode(code[i]);
			result = allocateClassDao.addRelationship(classId, trainningTeacher.getId());
		}
		return result;
	}

	@Override
	public int editRelationship(int classId, String[] teacherCode) {
		int result = 0;
		List<String> list = Arrays.asList(teacherCode);
		Set<String> set = new HashSet<String>(list);
		String[] code = (String[]) set.toArray(new String[0]);
		allocateClassDao.delRelationship(classId);
		for (int i = 0; i < code.length; i++) {
			TrainningTeacher trainningTeacher = trainningTeacherDao.findByCode(code[i]);
			result = allocateClassDao.addRelationship(classId, trainningTeacher.getId());
		}
		return result;
	}

	@Override
	public ClassTeacherRelationship findById(int id) {
		// TODO Auto-generated method stub
		ClassTeacherRelationship result = allocateClassDao.findById(id);
		return result;
	}

	@Override
	public List<ClassTeacherRelationship> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<ClassTeacherRelationship> result = allocateClassDao.findByClassId(id);
		return result;
	}

	@Override
	public List<ClassTeacherRelationship> findAll() {
		// TODO Auto-generated method stub
		List<ClassTeacherRelationship> result = allocateClassDao.findAll();
		return result;
	}

	@Override
	public int delRelationship(int id) {
		// TODO Auto-generated method stub
		int result = allocateClassDao.delRelationship(id);
		return result;
	}

}
