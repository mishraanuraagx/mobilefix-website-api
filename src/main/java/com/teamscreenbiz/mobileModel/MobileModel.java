package com.teamscreenbiz.mobileModel;


import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.product.Product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MobileModel{

  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min = 2,max = 10)
  private String name;
  @ManyToOne
  private Company company;
  @OneToMany
  private List<Product> products;

  public MobileModel(){
    super();
    products = new ArrayList<>();
  }

  public MobileModel(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void addProducts(Product product) {
    products.add(product);
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
    System.out.println("here");
    company.addMobileModels(this);
/*
     TODO max: this is not used when new object created via controller method, i think.
     TODO max: Need to add delete method in case 'company is changed or if this object deleted' to this method n company class addMobileModel method
*/
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
    MobileModel that = (MobileModel) obj;
    return id.equals(that.id);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
