package com.teamscreenbiz.company;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CompanyRepository extends CrudRepository<Company,Long>{
  Company findByCompanyName (String companyName);
  List<Company> findAll();

}
