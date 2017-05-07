package com.teamscreenbiz.product;


import com.teamscreenbiz.mobileModel.MobileModel;
import com.teamscreenbiz.transaction.Transaction;
import com.teamscreenbiz.vendor.Vendor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected Long id;

  @NotNull
  private String name;
  @ManyToOne
  private MobileModel mobileModel;
  //TODO max: Create an ENUM classs later
  private final static String problem = "Screen Replace";
  @ManyToMany
  private List<Vendor> vendors;
  private double rating;

  @OneToMany
  private List<Transaction> transactions;


  public Product(){
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


  public MobileModel getMobileModel() {
    if(mobileModel == null){
      return null;
    }
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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProblem() {
    return problem;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
