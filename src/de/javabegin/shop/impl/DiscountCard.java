/**
 * DiscountCard.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:31
 */

package de.javabegin.shop.impl;

import java.util.UUID;

public class DiscountCard {
   private int discount;
   private final String QRCode = UUID.randomUUID().toString();

   /**
    * На кого выдана дисконтная карта, позже заменить на класс покупатель
    */
   private String owner;

   public DiscountCard() {
   }

   public DiscountCard(int discount, String owner) {
      this.discount = discount;
      this.owner = owner;
   }

   public DiscountCard(int discount) {
      this.discount = discount;
   }

   public String getQRCode() {
      return QRCode;
   }

   public String getOwner() {
      return owner;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }

   public int getDiscount() {
      return discount;
   }

   public void setDiscount(int discount) {
      this.discount = discount;
   }
}
