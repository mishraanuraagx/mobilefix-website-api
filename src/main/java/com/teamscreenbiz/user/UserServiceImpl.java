package com.teamscreenbiz.user;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EntityManager em;

  @Override
  public User save(User user) {
    return null;
  }
}
