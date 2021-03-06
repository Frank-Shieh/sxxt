package sxxt.dao;

import java.util.List;

import sxxt.entity.Site;

public interface SiteDao {
	int addSite(Site site);

	int editSite(Site site);

	int editRent(Site site);

	int editAssign(Site site);

	Site findById(int id);

	List<Site> findByCompanyId(int id);

	List<Site> findAll();

	int delSite(int id);

	int delState(int id);
}
