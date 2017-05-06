package com.teamscreenbiz.mobileModel;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobileModelRepository extends CrudRepository<MobileModel,Long>{
  MobileModel findByName(String name);

  List<MobileModel> findAll();

  MobileModel findById(Long id);

}
