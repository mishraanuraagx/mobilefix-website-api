package com.teamscreenbiz.product;


import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.productPrice.ProductPriceCCT;
import com.teamscreenbiz.productPrice.ProductPriceCommercial;
import com.teamscreenbiz.vendor.Vendor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends BaseEntity {
  @NotNull
  private String name;
  @NotNull
  @ManyToOne
  private Company company;
  private String mobileModel;
  private final static String problem = "Screen Replace";
  @ManyToMany
  private List<Vendor> vendors;
  private double rating;
  @OneToOne
  private ProductPriceCCT productPriceCCT;
  @OneToOne
  private ProductPriceCommercial productPriceCommercial;


  protected Product(){
    super();
    vendors = new ArrayList<>();

  }

  public Product(String name, Company company, String mobileModel,
                 double rating) {
    this.name = name;
    this.company = company;
    this.mobileModel = mobileModel;
    this.rating = rating;
  }

  public ProductPriceCommercial getProductPriceCommercial() {
    return productPriceCommercial;
  }

  public void setProductPriceCommercial(
      ProductPriceCommercial productPriceCommercial) {
    this.productPriceCommercial = productPriceCommercial;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
    company.addProducts(this);
  }

  public String getMobileModel() {
    return mobileModel;
  }

  public void setMobileModel(String mobileModel) {
    this.mobileModel = mobileModel;
  }

  public List<Vendor> getVendor() {
    return vendors;
  }
  public void addVendor(Vendor vendor){
    vendor.addProduct(this);
    vendors.add(vendor);
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public ProductPriceCCT getProductPriceCCT() {
    return productPriceCCT;
  }

  public void setProductPriceCCT(ProductPriceCCT productPriceCCT) {
    this.productPriceCCT = productPriceCCT;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProblem() {
    return problem;
  }

}
