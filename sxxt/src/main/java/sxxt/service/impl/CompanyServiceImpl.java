package sxxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sxxt.dao.CompanyDao;
import sxxt.entity.Company;
import sxxt.service.interfaces.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Override
	public int addCompany(Company company) {
		int result = companyDao.addCompany(company);
		return result;
	}

	@Override
	public int editCompany(Company company) {
		int result = companyDao.editCompany(company);
		return result;
	}

	@Override
	public Company findById(int id) {
		Company result = companyDao.findById(id);
		return result;
	}

	@Override
	public List<Company> findAll() {
		List<Company> result = companyDao.findAll();
		return result;
	}

	@Override
	public int delCompany(int id) {
		int result = companyDao.delCompany(id);
		return result;
	}

}
