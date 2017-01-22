package sxxt.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.Company;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class CompanyDaoTest {
	@Autowired
	private CompanyDao companyDao;
	@Test
	public void testAddCompany()throws ParseException {
		Company c =new Company();
		c.setName("东莞银行");
		c.setPhone("12345");
		c.setAddress("东莞");
		c.setIntroduction("无");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		c.setFoundingDate(df.parse("1995-08-01"));
		companyDao.addCompany(c);
	}

	@Test
	public void testEditCompany() throws ParseException  {
		Company c =new Company();
		c.setId(2);
		c.setName("东莞集团");
		c.setPhone("12345");
		c.setAddress("东莞");
		c.setIntroduction("无");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		c.setFoundingDate(df.parse("1995-08-02"));
		companyDao.editCompany(c);
		
	}

	@Test
	public void testFindById() {
		System.out.println(companyDao.findById(1));
	}

	@Test
	public void testFindAll() {
		System.out.println(companyDao.findAll());
	}

	@Test
	public void testDelCompany() {
		companyDao.delCompany(2);
	}

}
