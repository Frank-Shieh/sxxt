package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.DataInfo;

public interface DataInfoDao {

	int addDataInfo(DataInfo dataInfo);

	int editDataInfo(DataInfo dataInfo);

	DataInfo findByUploadId(int id);

	DataInfo findById(int id);

	List<DataInfo> findByRole(int id);

	List<DataInfo> findAll();

	List<DataInfo> findByMyself(@Param("id") int id, @Param("role") int role);

	int delDataInfo(int id);
}
