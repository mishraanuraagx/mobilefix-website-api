package com.teamscreenbiz.productPrice;

import com.teamscreenbiz.core.BaseEntity;
import com.teamscreenbiz.product.Product;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ProductPriceCCT extends BaseEntity {
  private int minVal;
  private int maxVal; // commercial(maxval + profit)
  private int lastQuote;
  @OneToOne
  private Product product;
  @NotNull
  @OneToOne
  private ProductPriceCommercial productPriceCommercial;

  protected ProductPriceCCT(){
    super();
  }

  public ProductPriceCCT(int minVal, int maxVal, int lastQuote,
                         Product product) {
    this.minVal = minVal;
    this.maxVal = maxVal;
    this.lastQuote = lastQuote;
    this.product = product;
  }

  public ProductPriceCommercial getProductPriceCommercial() {
    return productPriceCommercial;
  }

  public void setProductPriceCommercial(
      ProductPriceCommercial productPriceCommercial) {
    this.productPriceCommercial = productPriceCommercial;
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

  public int getLastQuote() {
    return lastQuote;
  }

  public void setLastQuote(int lastQuote) {
    this.lastQuote = lastQuote;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
