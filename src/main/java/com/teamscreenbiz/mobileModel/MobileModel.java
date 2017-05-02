package com.teamscreenbiz.mobileModel;

import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.product.Product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MobileModel extends BaseEntity{
  @NotNull
  @Size(min = 2,max = 10)
  private String name;
  @ManyToOne
  private Company company;
  @OneToMany
  private List<Product> products;

  protected MobileModel(){
    super();
    products = new ArrayList<>();
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
    company.addMobileModels(this);
  }
}
