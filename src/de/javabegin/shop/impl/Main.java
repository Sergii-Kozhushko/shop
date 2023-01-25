/**
 * Main.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 15:12
 */

package de.javabegin.shop.impl;

import de.javabegin.shop.interfaces.ICheck;
import de.javabegin.shop.interfaces.IShop;
import de.javabegin.shop.interfaces.Position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static de.javabegin.shop.interfaces.Position.SELLER;

public class Main {
   public static void main(String[] args) {
      IShop shopLidlRemagen = new Shop("Lidl", " Zeppelinstrase 2, 53424 Remagen, Germany", "08004353361");
      Cashier cashierIvan = new Cashier("Иван Петренко", SELLER, shopLidlRemagen );
      Check check1 = new Check.CheckBuilder()
              .withNumber("0001")
              .withDateTimeCreation(new GregorianCalendar())
              .withShop(shopLidlRemagen)
              .withCashier(cashierIvan)
              .withDiscountCard(new DiscountCard(15))
              .build();
      check1.addProduct(new ProductInCheck("Zwiebelwurst", 2, new BigDecimal(12.32)));
      check1.addProduct(new ProductInCheck("Brot", 1, new BigDecimal(10.50)));
      check1.addProduct(new ProductInCheck("Irish Butter", 1, new BigDecimal(2.39)));
      check1.addProduct(new ProductInCheck("Tomaten", 5, new BigDecimal(2.10)));
      check1.addProduct(new ProductInCheck("Milch 1L", 2, new BigDecimal(1.10)));


      check1.print();
//      Person myPerson = new Person.Builder()
//              .withName("Jane")
//              .withSurname("Doe")
//              .withAge(32)
//              .withHeight(165)
//              .withWeight(70)
//              .build();

   }

}
