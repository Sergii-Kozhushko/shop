/**
 * Product.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:25
 */

package de.javabegin.shop.impl;

import java.math.BigDecimal;

/**
 * POJO-класс - просто товар
 */
public class Product {
   private BigDecimal price;
   private String name;

   public Product(BigDecimal price, String name) {
      this.price = price;
      this.name = name;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
