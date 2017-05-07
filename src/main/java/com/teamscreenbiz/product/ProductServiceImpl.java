package com.teamscreenbiz.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EntityManager em;

  @Override
  public Product save(Product product) {
    if(product.id == null){
      em.persist(product);
      return product;
    }

    return em.merge(product);
  }
}
