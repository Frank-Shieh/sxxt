package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.TrainningTeacher;

public interface TrainningTeacherService {
	int addTrainningTeacher(TrainningTeacher t);

	int editTrainningTeacher(TrainningTeacher t);

	List<TrainningTeacher> findAll();

	TrainningTeacher findById(int id);

	TrainningTeacher findByCode(String code);

	List<TrainningTeacher> findByCompanyId(int id);
	int updatePassword(String code, String password);

	int delTrainningTeacher(int id);
}
