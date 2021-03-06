package com.dyl.shop.cart.vo;

import java.io.Serializable;

import com.dyl.shop.product.vo.Product;

/**
 * 
 * @Description: 购物项对象
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午12:59:14
 */
public class CartItem implements Serializable {
  private Product product; // 购物项中商品信息
  private int count; // 购买某种商品数量
  private double subtotal; // 购买某种商品小计

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  // 小计自动计算的.
  public double getSubtotal() {
    return count * product.getShop_price();
  }
  /*
   * public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
   */

}
