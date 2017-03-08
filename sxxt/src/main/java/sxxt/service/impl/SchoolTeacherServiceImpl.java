package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.SchoolTeacherDao;
import sxxt.entity.SchoolTeacher;
import sxxt.service.interfaces.SchoolTeacherService;

@Service
public class SchoolTeacherServiceImpl implements SchoolTeacherService {
	@Autowired
	private SchoolTeacherDao SchoolTeacherDao;

	@Override
	public int addSchoolTeacher(SchoolTeacher s) {
		// TODO Auto-generated method stub
		int result = SchoolTeacherDao.addSchoolTeacher(s);
		return result;
	}

	@Override
	public int editSchoolTeacher(SchoolTeacher s) {
		// TODO Auto-generated method stub
		int result = SchoolTeacherDao.editSchoolTeacher(s);
		return result;
	}

	@Override
	public List<SchoolTeacher> findAll() {
		// TODO Auto-generated method stub
		List<SchoolTeacher> result = SchoolTeacherDao.findAll();
		return result;
	}

	@Override
	public SchoolTeacher findById(int id) {
		// TODO Auto-generated method stub
		SchoolTeacher result = SchoolTeacherDao.findById(id);
		return result;
	}

	@Override
	public int delSchoolTeacher(int id) {
		// TODO Auto-generated method stub
		int result = SchoolTeacherDao.delSchoolTeacher(id);
		return result;
	}

	@Override
	public List<SchoolTeacher> findBySchoolId(int id) {
		// TODO Auto-generated method stub
		List<SchoolTeacher> result = SchoolTeacherDao.findBySchoolId(id);
		return result;
	}

	@Override
	public SchoolTeacher findByCode(String code) {
		// TODO Auto-generated method stub
		SchoolTeacher result = SchoolTeacherDao.findByCode(code);
		return result;
	}

	@Override
	public int updatePassword(String code, String password) {
		// TODO Auto-generated method stub
		int result = SchoolTeacherDao.updatePassword(code,password);
		return result;
	}
}
