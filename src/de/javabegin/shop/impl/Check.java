/**
 * Check.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:47
 */

package de.javabegin.shop.impl;

import de.javabegin.shop.interfaces.ICheck;
import de.javabegin.shop.interfaces.IDocument;
import de.javabegin.shop.interfaces.IEmployee;
import de.javabegin.shop.interfaces.IShop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Check implements ICheck, IDocument {
   /**
    * Номер чека, специально стрингом тк может содержать и буквы
    */
   private String number;
   private Calendar dateTimeCreation;
   private IEmployee author;//автор чека
   private Cashier cashier;//кассир, это иногда разные сотрудники
   private IShop shop;
   private ArrayList<ProductInCheck> productList = new ArrayList<>();
   private DiscountCard discountCard;




   @Override
   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   @Override
   public ArrayList<ProductInCheck> getProductList() {
      return productList;
   }


   public void setProductList(ArrayList<ProductInCheck> productList) {
      this.productList = productList;
   }

   @Override
   public Calendar getDateTimeCreation() {
      return dateTimeCreation;
   }

   public void setDateTimeCreation(Calendar dateTimeCreation) {
      this.dateTimeCreation = dateTimeCreation;
   }

   /**
    * Метод возвращает формативрованную строку с датой и времнем создания чека
    * @return
    */
   public String dateTimePrintString(){
      // добавляет 1 к месяцу тк в классе Calendar нумерация с нуля
      String month = dateTimeCreation.get(Calendar.MONTH) + 1 + "";
      if (month.length() < 2) {
         month = "0" + month;
      }

      return "Date: " + dateTimeCreation.get(Calendar.DAY_OF_MONTH) + "." + month +
              "." + dateTimeCreation.get(Calendar.YEAR) + " " +
              "Time: " + dateTimeCreation.get(Calendar.HOUR) + ":" + dateTimeCreation.get(Calendar.MINUTE);
   }

   @Override
   public IEmployee getAuthor() {
      return author;
   }

   public void setAuthor(IEmployee author) {
      this.author = author;
   }

   @Override
   public IShop getShop() {
      return shop;
   }

   public void setShop(IShop shop) {
      this.shop = shop;
   }

   @Override
   public Cashier getCashier() {
      return cashier;
   }

   public void setCashier(Cashier cashier) {
      this.cashier = cashier;
   }

   @Override
   public DiscountCard getDiscountCard() {
      return discountCard;
   }

   public void setDiscountCard(DiscountCard discountCard) {
      this.discountCard = discountCard;
   }

   /**
    * Бизнес-метод. Добавить товар в конец чека
    * @param product
    */
   @Override
   public void addProduct(ProductInCheck product) {
      productList.add(product);

   }

   /**
    * Метод
    * @return
    */


   /**
    * Непосредственно печать чека
    */
   @Override
   public void print() {
      Printer.printCheck(this);
   }

      public Check(CheckBuilder checkBuilder) {
         this.number = checkBuilder.number;
         this.dateTimeCreation = checkBuilder.dateTimeCreation;
         this.author = checkBuilder.author;
         this.cashier = checkBuilder.cashier;
         this.shop = checkBuilder.shop;
         this.productList = checkBuilder.productList;
         this.discountCard = checkBuilder.discountCard;
   }

   public static class CheckBuilder {
      private String number;
      private Calendar dateTimeCreation;
      private IEmployee author;//автор чека
      private Cashier cashier;//кассир, это иногда разные сотрудники
      private IShop shop;
      private ArrayList<ProductInCheck> productList = new ArrayList<>();
      private DiscountCard discountCard;
      //private Check newCheck;

      public CheckBuilder() {
         super();
      }

      public CheckBuilder withNumber(String number){
         this.number = number;
         return this;
      }
      public CheckBuilder withDateTimeCreation(Calendar dateTimeCreation){
         this.dateTimeCreation = dateTimeCreation;
         return this;
      }
      public CheckBuilder withAuthor(IEmployee author){
         this.author = author;
         return this;
      }
      public CheckBuilder withCashier(Cashier cashier){
         this.cashier = cashier;
         return this;
      }
      public CheckBuilder withShop(IShop shop){
         this.shop = shop;
         return this;
      }
      public CheckBuilder withDiscountCard(DiscountCard discountCard){
         this.discountCard = discountCard;
         return this;
      }

      public CheckBuilder withProductList(ArrayList<ProductInCheck> productList){
         this.productList = productList;
         return this;
      }

      public Check build(){
         return new Check(this);
      }
   }


}
