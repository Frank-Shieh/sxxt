package sxxt.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Company;
import sxxt.entity.TrainningTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TrainningTeacherDaoTest {
	@Autowired
	private TrainningTeacherDao TrainningTeacherDao;

	@Test
	public void testAddTrainningTeacher() {
		TrainningTeacher s = new TrainningTeacher();
		s.setCode("A1234");
		Company c = new Company();
		c.setId(1);
		s.setCompany(c);
		s.setPositionName("讲师");
		s.setPassword("1234");
		s.setName("张三");
		TrainningTeacherDao.addTrainningTeacher(s);
	}

	@Test
	public void testEditTrainningTeacher() {
		TrainningTeacher s = new TrainningTeacher();
		s.setId(1);
		s.setCode("A1235");
		Company c = new Company();
		c.setId(2);
		s.setCompany(c);
		s.setPositionName("讲师");
		s.setPassword("123456");
		s.setName("李四");
		TrainningTeacherDao.editTrainningTeacher(s);

	}

	@Test
	public void testFindAll() {
		System.out.println(TrainningTeacherDao.findAll());
	}

	@Test
	public void testFindById() {
		System.out.println(TrainningTeacherDao.findById(2));
	}

	@Test
	public void testDelTrainningTeacher() {
		System.out.println(TrainningTeacherDao.delTrainningTeacher(2));
	}

}
