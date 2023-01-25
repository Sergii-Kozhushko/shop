/**
 * Shop.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 15:14
 */

package de.javabegin.shop.impl;

import de.javabegin.shop.interfaces.IShop;

public class Shop implements IShop {
   private String name;
   private String address;
   private String phone;

   public Shop() {
   }

   public Shop(String name, String address, String phone) {
      this.name = name;
      this.address = address;
      this.phone = phone;
   }

   @Override
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   @Override
   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
}
