package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.TrainningTeacher;

public interface TrainningTeacherService {
	int addTrainningTeacher(TrainningTeacher t);

	int editTrainningTeacher(TrainningTeacher t);

	List<TrainningTeacher> findAll();

	TrainningTeacher findById(int id);

	int delTrainningTeacher(int id);
}
