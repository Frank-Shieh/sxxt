package sxxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sxxt.entity.SiteManager;

public interface SiteManagerDao {
	int addSiteManager(SiteManager s);

	int editSiteManager(SiteManager s);

	List<SiteManager> findAll();

	List<SiteManager> findByCompanyId(int id);

	SiteManager findById(int id);

	SiteManager findByCode(String code);
	int updatePassword(@Param("code")String code,@Param("password")String password);

	int delSiteManager(int id);
}
