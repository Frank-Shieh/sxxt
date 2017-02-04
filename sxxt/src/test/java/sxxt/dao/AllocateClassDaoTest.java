package sxxt.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class AllocateClassDaoTest {

	@Autowired
	AllocateClassDao allocateClassDao;
	
	@Test
	public void testAddRelationship() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditRelationship() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByClassId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		System.out.println(allocateClassDao.findAll());
	}

	@Test
	public void testDelRelationship() {
		fail("Not yet implemented");
	}

}
