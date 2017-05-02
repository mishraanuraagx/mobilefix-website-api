package com.teamscreenbiz.company;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CompanyRepository extends CrudRepository<Company,Long> {

  Company findByCompanyName (String companyName);
  List<Company> findAll();
  Company findById(Long id);


//  default Company save(Company company) {
//
//  }

  @Modifying
  @Query("update Company u set u.companyName = ?1, u.desc = ?2 where u.id = ?3")
  void setUserInfoById(String companyName, String desc, Long Id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE Company SET companyName = :#{company.getCompanyName},desc = :#{company.getDesc} WHERE companyId = :#{company.getId}")
  int update(@Param("company") Company company);


  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE Company SET companyName = :companyName,desc = :desc WHERE company_Id = :id")
  int update2(@Param("companyName") String companyName,@Param("desc") String desc,@Param("id")Long id);



}
