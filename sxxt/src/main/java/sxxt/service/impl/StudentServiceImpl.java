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
		return 0;
	}

	@Override
	public int editStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findByClassId(int id) {
		// TODO Auto-generated method stub
		List<Student> result=studentDao.findByClassId(id);
		return result;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		Student result=studentDao.findById(id);
		return result;
	}

	@Override
	public int delStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
