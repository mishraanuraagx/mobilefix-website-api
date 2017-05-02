package com.teamscreenbiz.product;


import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.mobileModel.MobileModel;
import com.teamscreenbiz.productPrice.ProductPriceCCT;
import com.teamscreenbiz.productPrice.ProductPriceCommercial;
import com.teamscreenbiz.transaction.Transaction;
import com.teamscreenbiz.vendor.Vendor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends BaseEntity {
  @NotNull
  private String name;
  @ManyToOne
  private MobileModel mobileModel;
  //TODO max: Create an ENUM classs later
  private final static String problem = "Screen Replace";
  @ManyToMany
  private List<Vendor> vendors;
  private double rating;
  @OneToOne
  private ProductPriceCCT productPriceCCT;
  @OneToOne
  private ProductPriceCommercial productPriceCommercial;
  @OneToMany
  private List<Transaction> transactions;


  protected Product(){
    super();
    vendors = new ArrayList<>();
    transactions = new ArrayList<>();

  }

  public Product(String name,double rating) {
    this.name = name;
    this.rating = rating;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public ProductPriceCommercial getProductPriceCommercial() {
    return productPriceCommercial;
  }

  public void setProductPriceCommercial(
      ProductPriceCommercial productPriceCommercial) {
    this.productPriceCommercial = productPriceCommercial;
  }

  public MobileModel getMobileModel() {
    return mobileModel;
  }

  public void setMobileModel(MobileModel mobileModel) {
    this.mobileModel = mobileModel;
    mobileModel.addProducts(this);
  }

  public List<Vendor> getVendors() {
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
