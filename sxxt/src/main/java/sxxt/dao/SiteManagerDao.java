package sxxt.dao;

import java.util.List;

import sxxt.entity.SiteManager;

public interface SiteManagerDao {
	int addSiteManager(SiteManager s);

	int editSiteManager(SiteManager s);

	List<SiteManager> findAll();

	List<SiteManager> findByCompanyId(int id);

	SiteManager findById(int id);

	SiteManager findByCode(String code);

	int delSiteManager(int id);
}
