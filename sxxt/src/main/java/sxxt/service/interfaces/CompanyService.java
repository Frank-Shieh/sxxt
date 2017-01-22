package sxxt.service.interfaces;

import java.util.List;

import sxxt.entity.Company;

public interface CompanyService {
	int addCompany(Company company);

	int editCompany(Company company);

	Company findById(int id);

	List<Company> findAll();

	int delCompany(int id);
}
