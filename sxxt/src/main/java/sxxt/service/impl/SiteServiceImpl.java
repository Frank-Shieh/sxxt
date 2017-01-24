package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.SiteDao;
import sxxt.entity.Site;
import sxxt.service.interfaces.SiteService;

@Service
public class SiteServiceImpl implements SiteService {
	@Autowired
	private SiteDao SiteDao;

	@Override
	public int addSite(Site s) {
		// TODO Auto-generated method stub
		int result = SiteDao.addSite(s);
		return result;
	}

	@Override
	public int editSite(Site s) {
		// TODO Auto-generated method stub
		int result = SiteDao.editSite(s);
		return result;
	}

	@Override
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		List<Site> result = SiteDao.findAll();
		return result;
	}

	@Override
	public Site findById(int id) {
		// TODO Auto-generated method stub
		Site result = SiteDao.findById(id);
		return result;
	}

	@Override
	public int delSite(int id) {
		// TODO Auto-generated method stub
		int result = SiteDao.delSite(id);
		return result;
	}

	@Override
	public int editRent(Site site) {
		// TODO Auto-generated method stub
		int result = SiteDao.editRent(site);
		return result;
	}

	@Override
	public int editAssign(Site site) {
		// TODO Auto-generated method stub
		int state = site.getState();
		if (state == 1) {
			site.setState(2);
		}
		int result = SiteDao.editAssign(site);
		return result;
	}

	@Override
	public int delState(int id) {
		// TODO Auto-generated method stub
		int result = SiteDao.delState(id);
		return result;
	}
}
