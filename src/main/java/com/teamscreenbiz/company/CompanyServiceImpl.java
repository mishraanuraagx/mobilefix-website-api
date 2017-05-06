package com.teamscreenbiz.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private CompanyRepository repository;

  @Autowired
  private EntityManager em;

  @Override
  public Company save(Company company) {
//    return repository.save(company);
    System.out.println(company.getId());
    if(company.getId() == null){
      em.persist(company);

      return company;
    }
    return em.merge(company);
  }
}
