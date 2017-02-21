package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.SiteManagerDao;
import sxxt.entity.SiteManager;
import sxxt.service.interfaces.SiteManagerService;

@Service
public class SiteManagerServiceImpl implements SiteManagerService {
	@Autowired
	private SiteManagerDao siteManagerDao;

	@Override
	public int addSiteManager(SiteManager s) {
		// TODO Auto-generated method stub
		int result = siteManagerDao.addSiteManager(s);
		return result;
	}

	@Override
	public int editSiteManager(SiteManager s) {
		// TODO Auto-generated method stub
		int result = siteManagerDao.editSiteManager(s);
		return result;
	}

	@Override
	public List<SiteManager> findAll() {
		// TODO Auto-generated method stub
		List<SiteManager> result = siteManagerDao.findAll();
		return result;
	}

	@Override
	public SiteManager findById(int id) {
		// TODO Auto-generated method stub
		SiteManager result = siteManagerDao.findById(id);
		return result;
	}

	@Override
	public int delSiteManager(int id) {
		// TODO Auto-generated method stub
		int result = siteManagerDao.delSiteManager(id);
		return result;
	}

	@Override
	public List<SiteManager> findByCompanyId(int id) {
		List<SiteManager> result = siteManagerDao.findByCompanyId(id);
		return result;
	}

	@Override
	public SiteManager findByCode(String code) {
		// TODO Auto-generated method stub
		SiteManager result = siteManagerDao.findByCode(code);
		return result;
	}

}
