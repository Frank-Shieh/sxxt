package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.DataInfo;

public interface DataInfoService {

	int addDataInfo(DataInfo dataInfo);

	int editDataInfo(DataInfo dataInfo);

	DataInfo findByUploadId(int id);

	DataInfo findById(int id);

	List<DataInfo> findByRole(int id);

	List<DataInfo> findAll();

	List<DataInfo> findByMyself(int id, int role);

	int delDataInfo(int id);

}
