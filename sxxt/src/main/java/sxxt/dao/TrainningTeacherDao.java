package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.TrainningTeacher;

public interface TrainningTeacherDao {
	int addTrainningTeacher(TrainningTeacher t);

	int editTrainningTeacher(TrainningTeacher t);

	List<TrainningTeacher> findAll();

	TrainningTeacher findById(int id);

	List<TrainningTeacher> findByCompanyId(int id);

	TrainningTeacher findByCode(String teacherCode);
	int updatePassword(@Param("code")String code,@Param("password")String password);

	int delTrainningTeacher(int id);
}
