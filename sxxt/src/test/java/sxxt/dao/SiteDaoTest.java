package sxxt.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Company;
import sxxt.entity.Site;
import sxxt.entity.SiteManager;
import sxxt.entity.TrainningTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SiteDaoTest {
	@Autowired
	private SiteDao siteDao;

	@Test
	public void testAddSite() {
		Site s = new Site();
		s.setAreaName("A区");
		s.setBuilding("C栋");
		s.setFloor("2楼");
		s.setClassroomCode("201");
		s.setNum(100);
		SiteManager siteManager = new SiteManager();
		siteManager.setId(1);
		s.setSiteManager(siteManager);
		TrainningTeacher t = new TrainningTeacher();
		t.setId(1);
		s.setTrainningTeacher(t);
		Company c= new Company();
		c.setId(1);
		s.setCompany(c);
		siteDao.addSite(s);

	}

	@Test
	public void testEditSite() {
		Site s = new Site();
		s.setId(1);
		s.setAreaName("A区");
		s.setBuilding("B栋");
		s.setFloor("3楼");
		s.setClassroomCode("302");
		s.setNum(100);
		SiteManager siteManager = new SiteManager();
		siteManager.setId(1);
		s.setSiteManager(siteManager);
		TrainningTeacher t = new TrainningTeacher();
		t.setId(2);
		s.setTrainningTeacher(t);
		Company c= new Company();
		c.setId(2);
		s.setCompany(c);
		siteDao.editSite(s);
	}

	@Test
	public void testFindById() {
		System.out.println(siteDao.findById(1).getCompany().getName());
	}

	@Test
	public void testFindAll() {
		System.out.println(siteDao.findAll());
	}

	@Test
	public void testDelSite() {
		System.out.println(siteDao.delSite(2));
	}

}
