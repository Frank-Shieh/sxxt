package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import sxxt.entity.TaskClassRelationship;
import sxxt.entity.TrainningTask;

public interface TrainningTaskDao {

	@Transactional
	int addTrainningTask(TrainningTask TrainningTask);

	int editTrainningTask(TrainningTask TrainningTask);

	List<TrainningTask> findAll();

	TrainningTask findById(int id);
	
	List<TrainningTask> findByClassId(int id);
	
	@Transactional
	int delTrainningTask(int id);

	/**
	 * 下面是操作教学任务和班级之间的表即task_class_relationship
	 */

	int addTaskClass(@Param("taskId") int taskId, @Param("classId") int classId);

	List<TaskClassRelationship> findByTaskId(@Param("taskId") int taskId);

	int editTaskClass(@Param("taskId") int taskId, @Param("classId") int classId);

	int delTasktClass(int id);

}
