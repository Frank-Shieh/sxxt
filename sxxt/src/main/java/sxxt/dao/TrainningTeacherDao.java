package sxxt.dao;

import java.util.List;

import sxxt.entity.TrainningTeacher;

public interface TrainningTeacherDao {
	int addTrainningTeacher(TrainningTeacher t);

	int editTrainningTeacher(TrainningTeacher t);

	List<TrainningTeacher> findAll();

	TrainningTeacher findById(int id);

	List<TrainningTeacher> findByCompanyId(int id);
	
	int delTrainningTeacher(int id);
}
