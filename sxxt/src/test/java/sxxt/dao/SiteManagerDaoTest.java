package sxxt.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Company;
import sxxt.entity.SiteManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SiteManagerDaoTest {
	@Autowired
	private SiteManagerDao siteManagerDao;

	@Test
	public void testAddSiteManager() {
		SiteManager s = new SiteManager();
		s.setCode("A1234");
		Company c = new Company();
		c.setId(1);
		s.setCompany(c);
		s.setPassword("1234");
		s.setName("张三");
		siteManagerDao.addSiteManager(s);
	}

	@Test
	public void testEditSiteManager() {
		SiteManager s = new SiteManager();
		s.setId(1);
		s.setCode("A1235");
		Company c = new Company();
		c.setId(2);
		s.setCompany(c);
		s.setPassword("123456");
		s.setName("李四");
		siteManagerDao.editSiteManager(s);

	}

	@Test
	public void testFindAll() {
		System.out.println(siteManagerDao.findAll());
	}

	@Test
	public void testFindById() {
		System.out.println(siteManagerDao.findById(2));
	}

	@Test
	public void testDelSiteManager() {
		System.out.println(siteManagerDao.delSiteManager(2));
	}

}
