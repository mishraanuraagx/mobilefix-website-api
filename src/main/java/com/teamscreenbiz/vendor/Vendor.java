package com.teamscreenbiz.vendor;

import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.product.Product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Vendor extends BaseEntity {
  @NotNull
  private String name;
  private String address;
  private Long phoneNumber;
  private int[] rating = new int[6];
  private int finalRating;
  private String desc;
  @ManyToMany
  private List<Product> products;

  protected Vendor(){
    super();
    products = new ArrayList<>();
  }

  public Vendor(String name, String address, Long phoneNumber, int[] rating, int finalRating,
                String desc) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.rating = rating;
    this.finalRating = finalRating;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int[] getRating() {
    return rating;
  }

  public void setRating(int[] rating) {
    this.rating = rating;
  }

  public int getFinalRating() {
    return finalRating;
  }

  public void setFinalRating(int finalRating) {
    this.finalRating = finalRating;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public List<Product> getProduct() {
    return products;
  }

  public void addProduct(Product product) {
    products.add(product);

  }
}
