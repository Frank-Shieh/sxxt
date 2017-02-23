package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.DataInfoDao;
import sxxt.entity.DataInfo;
import sxxt.service.interfaces.DataInfoService;

@Service
public class DataInfoServiceImpl implements DataInfoService {
	@Autowired
	private DataInfoDao dataInfoDao;

	@Override
	public int addDataInfo(DataInfo dataInfo) {
		int result = dataInfoDao.addDataInfo(dataInfo);
		return result;
	}

	@Override
	public int editDataInfo(DataInfo dataInfo) {
		int result = dataInfoDao.editDataInfo(dataInfo);
		return result;
	}

	@Override
	public DataInfo findByUploadId(int id) {
		DataInfo result = dataInfoDao.findByUploadId(id);
		return result;
	}

	@Override
	public DataInfo findById(int id) {
		DataInfo result = dataInfoDao.findById(id);
		return result;
	}

	@Override
	public List<DataInfo> findByRole(int id) {
		List<DataInfo> result = dataInfoDao.findByRole(id);
		return result;
	}

	@Override
	public List<DataInfo> findAll() {
		List<DataInfo> result = dataInfoDao.findAll();
		return result;
	}

	@Override
	public int delDataInfo(int id) {
		int result = dataInfoDao.delDataInfo(id);
		return result;
	}

	@Override
	public List<DataInfo> findByMyself(int id, int role) {
		// TODO Auto-generated method stub
		List<DataInfo> result = dataInfoDao.findByMyself(id, role);
		return result;
	}

}
