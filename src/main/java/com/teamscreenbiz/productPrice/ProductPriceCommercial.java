package com.teamscreenbiz.productPrice;

import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.product.Product;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ProductPriceCommercial extends BaseEntity{
  //TODO max: add product id
  private int minVal;
  private int maxVal;
  private int availableAmount;
  private int profit;
  @NotNull
  @OneToOne
  private Product product;
  @OneToOne
  private ProductPriceCCT productPriceCCT;

  protected ProductPriceCommercial(){
    super();
  }

  public ProductPriceCommercial(int minVal, int maxVal, int availableAmount, int profit,
                                Product product) {
    this.minVal = minVal;
    this.maxVal = maxVal;
    this.availableAmount = availableAmount;
    this.profit = profit;
    this.product = product;
  }

  public int getMinVal() {
    return minVal;
  }

  public void setMinVal(int minVal) {
    this.minVal = minVal;
  }

  public int getMaxVal() {
    return maxVal;
  }

  public void setMaxVal(int maxVal) {
    this.maxVal = maxVal;
  }

  public int getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(int availableAmount) {
    this.availableAmount = availableAmount;
  }

  public int getProfit() {
    return profit;
  }

  public void setProfit(int profit) {
    this.profit = profit;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ProductPriceCCT getProductPriceCCT() {
    return productPriceCCT;
  }

  public void setProductPriceCCT(ProductPriceCCT productPriceCCT) {
    this.productPriceCCT = productPriceCCT;
  }
}
