package com.teamscreenbiz.companyEmployee;


import org.springframework.data.repository.CrudRepository;

public interface CompanyEmployeeRepository extends CrudRepository<CompanyEmployee,Long>{
  CompanyEmployee findByUsername(String username);

}
