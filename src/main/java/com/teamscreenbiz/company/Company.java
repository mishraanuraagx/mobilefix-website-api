package com.teamscreenbiz.company;

import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.mobileModel.MobileModel;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Company /*extends BaseEntity*/{

  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min = 2, max = 16)
  private String companyName;
  @Length(max = 60)
  private String desc;
  //TODO max: add LOGO class later for pic saving
  @OneToMany(mappedBy = "company")
  private List<MobileModel> mobileModels;

  public Company()
  {
    super();
//    mobileModels = new ArrayList<>();
  }

  public Company(String companyName, String desc) {
    this.companyName = companyName;
    this.desc = desc;
  }
  @OneToMany
  public List<MobileModel> getMobileModels() {
    return mobileModels;
  }

  public void addMobileModels(MobileModel mobileModel) {
    System.out.println(mobileModel.getId());
    System.out.println(mobileModel.getName());
    System.out.println(companyName);
    System.out.println(id);
    System.out.println(mobileModel);
    if(mobileModels == null){
      mobileModels = new ArrayList<>();
    }
    mobileModels.add(mobileModel);
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc)
  {
    this.desc = desc;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (id == null || obj == null || getClass() != obj.getClass())
      return false;
    Company that = (Company) obj;
    return id.equals(that.id);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
