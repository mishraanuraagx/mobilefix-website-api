package com.teamscreenbiz.company;

import com.teamscreenbiz.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Company extends BaseEntity{
  private String companyName;
  private String Desc;
  //TODO max: add LOGO class later for pic saving

  protected Company(){
    super();
  }

  public Company(String companyName, String desc) {
    this();
    this.companyName = companyName;
    Desc = desc;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDesc() {
    return Desc;
  }

  public void setDesc(String desc) {
    Desc = desc;
  }
}
