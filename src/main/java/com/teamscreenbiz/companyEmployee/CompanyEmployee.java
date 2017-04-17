package com.teamscreenbiz.companyEmployee;

import com.teamscreenbiz.core.BaseEntity;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class CompanyEmployee extends BaseEntity {
  private String name;
  private Long phoneNumber;
  private String email;
  private String address;
  private Date date;
  private String username;
  private String password;
  private String pass_Hint;
  private char sex;
  //TODO max: add pic class file
  //TODO max: add pdf class file
  //TODO max: add ID_PROOF pdf file
  private String[] roles;

}
