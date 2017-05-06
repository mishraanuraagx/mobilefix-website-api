package com.teamscreenbiz.mobileModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MobileModelServiceImpl implements MobileModelService {

  @Autowired
  private MobileModelRepository repository;

  @Autowired
  private EntityManager em;

  @Override
  public MobileModel save(MobileModel mobileModel) {
//    return repository.save(company);
    System.out.println(mobileModel.getId());
    if(mobileModel.getId() == null){
      em.persist(mobileModel);

      return mobileModel;
    }
    return em.merge(mobileModel);
  }
}
