package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.StudentDao;
import sxxt.entity.Student;
import sxxt.service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		int result = studentDao.addStudent(student);
		return result;
	}

	@Override
	public int editStudent(Student student) {
		// TODO Auto-generated method stub
		int result = studentDao.editStudent(student);
		return result;
	}

	@Override
	public List<Student> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<Student> result = studentDao.findByClassId(id);
		return result;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		Student result = studentDao.findById(id);
		return result;
	}

	@Override
	public int delStudent(int id) {
		// TODO Auto-generated method stub
		int result = studentDao.delStudent(id);
		return result;
	}

	@Override
	public Student findByCode(String code) {
		// TODO Auto-generated method stub
		Student result = studentDao.findByCode(code);
		return result;
	}
	@Override
	public int updatePassword(String code, String password) {
		// TODO Auto-generated method stub
		int result = studentDao.updatePassword(code,password);
		return result;
	}
}
