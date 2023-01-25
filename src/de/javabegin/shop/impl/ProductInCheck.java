/**
 * ProductInCheck.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:28
 */

package de.javabegin.shop.impl;

import java.math.BigDecimal;

/**
 * Товар в чеке
 */
public class ProductInCheck extends Product{
   private int quantity;


   public ProductInCheck(String name, int quantity, BigDecimal price) {
      super(price, name);
      this.quantity = quantity;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}
