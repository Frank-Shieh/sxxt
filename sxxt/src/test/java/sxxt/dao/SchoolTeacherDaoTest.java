package sxxt.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sxxt.entity.School;
import sxxt.entity.SchoolTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SchoolTeacherDaoTest {
	@Autowired
	SchoolTeacherDao schoolTeacherDao;

	@Test
	public void testAddSchoolTeacher() {
		SchoolTeacher s = new SchoolTeacher();
		s.setName("李四");
		s.setCode("B12345");
		s.setPositionName("副教授");
		School school = new School();
		school.setId(2);
		s.setSchool(school);
		s.setPassword("1234");
		schoolTeacherDao.addSchoolTeacher(s);
	}

	@Test
	public void testEditSchoolTeacher() {
		SchoolTeacher s = new SchoolTeacher();
		s.setId(1);
		s.setName("张三");
		s.setCode("A12345");
		s.setPositionName("教授");
		School school = new School();
		school.setId(1);
		s.setSchool(school);
		s.setPassword("1234");
		schoolTeacherDao.editSchoolTeacher(s);
	}

	@Test
	public void testFindAll() {
		System.out.println(schoolTeacherDao.findAll());
	}

	@Test
	public void testFindById() {
		System.out.println(schoolTeacherDao.findById(1));
	}

	@Test
	public void testFindBySchoolId() {
		System.out.println(schoolTeacherDao.findBySchoolId(1));
	}

	@Test
	public void testDelSchoolTeacher() {
		System.out.println(schoolTeacherDao.delSchoolTeacher(1));
	}

}
