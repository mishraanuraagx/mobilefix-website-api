package com.teamscreenbiz.mobileModel;


import org.springframework.data.repository.CrudRepository;

public interface MobileModelRepository extends CrudRepository<MobileModel,Long>{
  MobileModel findByName(String name);

}
