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

import sxxt.entity.EducationManager;
import sxxt.entity.TaskTeacherRelationship;
import sxxt.entity.TeachingTask;
import sxxt.entity.TrainningTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TeachingTaskDaoTest {
	@Autowired
	TeachingTaskDao teachingTaskDao;

	@Test
	public void testAddTeachingTask() throws ParseException {
		TeachingTask t = new TeachingTask();
		t.setName("教学计划");
		t.setContent("12345");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse("2017-01-25");
		t.setStartDate(startDate);
		Date endDate = dateFormat.parse("2017-01-27");
		t.setEndDate(endDate);
		EducationManager e = new EducationManager();
		e.setId(1);
		t.setEducationManager(e);
		Date releaseDate = dateFormat.parse("2017-01-24");
		t.setReleaseDate(releaseDate);
		teachingTaskDao.addTeachingTask(t);
	}

	@Test
	public void testEditTeachingTask() throws ParseException {
		TeachingTask t = new TeachingTask();
		t.setName("教学计划");
		t.setContent("1234");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse("2017-01-25");
		t.setStartDate(startDate);
		Date endDate = dateFormat.parse("2017-01-27");
		t.setEndDate(endDate);
		EducationManager e = new EducationManager();
		e.setId(2);
		t.setEducationManager(e);
		Date releaseDate = dateFormat.parse("2017-01-24");
		t.setReleaseDate(releaseDate);
		t.setId(2);
		teachingTaskDao.editTeachingTask(t);
	}

	@Test
	public void testFindAll() {
		System.out.println(teachingTaskDao.findAll());
	}

	@Test
	public void testFindById() {
		System.out.println(teachingTaskDao.findById(1));
	}

	@Test
	public void testDelTeachingTask() {
		System.out.println(teachingTaskDao.delTeachingTask(1));
	}

	@Test
	public void testAddTaskTeacher() {
		TaskTeacherRelationship t=new TaskTeacherRelationship();
		TeachingTask teachingTask =new TeachingTask();
		teachingTask.setId(1);
		TrainningTeacher trainningTeacher= new TrainningTeacher();
		trainningTeacher.setId(1);
		t.setTeachingTask(teachingTask);
		t.setTrainningTeacher(trainningTeacher);
		teachingTaskDao.addTaskTeacher(1, 1);
	}

	@Test
	public void testFindByTaskId() {
		System.out.println(teachingTaskDao.findByTaskId(1));
	}

	@Test
	public void testEditTaskTeacher() {
		teachingTaskDao.editTaskTeacher(1, 2);
	}

	@Test
	public void testDelTasktTeacher() {
		teachingTaskDao.delTasktTeacher(1);
	}

}
