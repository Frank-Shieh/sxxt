package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.SiteManager;

public interface SiteManagerService {
	int addSiteManager(SiteManager s);

	int editSiteManager(SiteManager s);

	List<SiteManager> findAll();

	SiteManager findById(int id);

	int delSiteManager(int id);
}
