package com.teamscreenbiz.company;

import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.product.Product;

import org.aspectj.weaver.ast.Not;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Company extends BaseEntity{
  @NotNull
  private String companyName;
  private String desc;
  //TODO max: add LOGO class later for pic saving
  @OneToMany
  private List<Product> products;

  protected Company()
  {
    super();
    products = new ArrayList<>();
  }

  public Company(String companyName, String desc) {
    this.companyName = companyName;
    this.desc = desc;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void addProducts(Product product) {
    products.add(product);
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
}
