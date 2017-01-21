package sxxt.dao;

import static org.junit.Assert.*;
import sxxt.entity.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class ClassDaoTest {
	@Autowired
	private ClassDao classDao;
	@Test
	public void findById() {
	System.out.println(classDao.findById(1));
	}
	@Test
	public void findAll() {
	System.out.println(classDao.findAll());
	}

	@Test
	public void addClass() {
		Class classId= new Class();
		classId.setName("13软件工程R6班");
		classDao.addClass(classId);
		System.out.println(classId.getId());
	}

}
