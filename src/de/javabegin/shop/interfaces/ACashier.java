/**
 * ACashier.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:03
 */

package de.javabegin.shop.interfaces;

public abstract class ACashier implements IEmployee{
   private String name;

   /**
    * Основной магазин, где работает кассир
    */
   private IShop mainShop;

   @Override
   public String getName() {
      return name;
   }

   public IShop getMainShop(){
      return mainShop;
   }
}
