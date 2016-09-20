package sxxt.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Student;
import sxxt.entity.Class;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class StudentDaoTest {
	@Autowired
	private StudentDao studentDao;
	@Test
	public void findById() {
	System.out.println(studentDao.findById(2));
	}
	@Test
	public void findByClassId() {
	System.out.println(studentDao.findByClassId(1));
	}
	@Test
	public void addStudent() throws ParseException {
		Student student=new Student();
		student.setCode("201330340224");
	student.setAge(20);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date birthDate = dateFormat.parse("1995-08-25");
	student.setBirthDate(birthDate);
	Class classId = new Class();
	classId.setId(1);
    student.setClassId(classId);
    student.setPassword("19950825");
    student.setStudentPhone("15692007886");
    studentDao.addStudent(student);
	}
}
