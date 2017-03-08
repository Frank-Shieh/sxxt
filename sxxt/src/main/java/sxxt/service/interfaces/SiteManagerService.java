package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.SiteManager;

public interface SiteManagerService {
	int addSiteManager(SiteManager s);

	int editSiteManager(SiteManager s);

	List<SiteManager> findAll();

	List<SiteManager> findByCompanyId(int id);

	SiteManager findById(int id);

	SiteManager findByCode(String code);
	int updatePassword(String code, String password);

	int delSiteManager(int id);
}
