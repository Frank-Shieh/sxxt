package sxxt.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class MajorDaoTest {
	@Autowired
	private MajorDao majorDao;
	@Test
	public void findBySchoolId() {
		System.out.println(majorDao.findBySchoolId(1));
	}

}
