package sxxt.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Student;
import sxxt.service.interfaces.StudentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class StudentServiceImplTest {
	@Autowired
	private StudentService studentService;
	@Test
	public void findByClassId() {
		List<Student> result=studentService.findByClassId(1);
		System.out.println(result);
	}

}
