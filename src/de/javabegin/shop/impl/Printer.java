/**
 * Printer.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 19:54
 */

package de.javabegin.shop.impl;

import de.javabegin.shop.interfaces.ICheck;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;

import static java.math.BigDecimal.ROUND_DOWN;

//класс печатает строку по центру консоли с заданной шириной
public class Printer {
    private static final int WIDTH = 80;

    public static void printCheck(Check check){
        String datetime = "";
        System.out.println(formatPrintString("CASH RECEIPT #" + check.getNumber(), "center"));
        if (check.getShop() != null) {
            System.out.println(formatPrintString(check.getShop().getName(), "center"));
            System.out.println(formatPrintString(check.getShop().getAddress(), "center"));
            System.out.println(formatPrintString("Tel.: " + check.getShop().getPhone(), "center"));
        }
        datetime = check.dateTimePrintString();
        if (check.getCashier() != null){
            System.out.println(formatEdgedTwoStrings("Cashier: " + check.getCashier().getName(), datetime ));
        }
        else
            System.out.println(formatPrintString(datetime, "left"));
        System.out.println(formatLine());


        BigDecimal price, sum, allSumm = new BigDecimal(0);
        int quantity;
        String title1 = "";
        for (int i = 0; i < check.getProductList().size(); i++){
            //округляем BigDecimal до 2-х знаков после нуля
            price = check.getProductList().get(i).getPrice().setScale(2, RoundingMode.DOWN);
            quantity = check.getProductList().get(i).getQuantity();
            sum = price.multiply(BigDecimal.valueOf(quantity));
            title1 = check.getProductList().get(i).getName();

            System.out.println(formatEdgedTwoStrings((i+1) + ". " + quantity + " " + title1
                    ,"$" + price.toString() + " $" + sum.toString() ));
            allSumm = allSumm.add(sum);
        }
        System.out.println(formatLine());
        //BigDecimal hundred =
        BigDecimal allSumWithDiscount = allSumm.divide(new BigDecimal("100"));
        BigDecimal discountSum;
        discountSum = allSumWithDiscount.multiply(BigDecimal.valueOf(check.getDiscountCard().getDiscount()));
        discountSum = discountSum.round(new MathContext(3));
        allSumWithDiscount = allSumm.subtract(discountSum);
        allSumWithDiscount = allSumWithDiscount.round(new MathContext(4));

        System.out.println(formatEdgedTwoStrings("Total:", "$" + allSumm.toString()) );
        if (check.getDiscountCard() != null){
            System.out.println(formatEdgedTwoStrings(
                        "Sum of discount (card " + check.getDiscountCard().getDiscount() + "%)", "" +
                            "$" + discountSum.toString()));
            System.out.println(formatEdgedTwoStrings("Total sum with discount:", allSumWithDiscount.toString()));

        }


    }



    // метод возвращает строку из пробелов для форматирования вывода
    private String offsetSpacesString(int width, String title) {
        int length = width - title.length();
        String s = "";
        for (int i = 0; i < length; i++) {
            s = s + " ";
        }
        return s;
    }

    private static String formatPrintString(String string, String align){
        String s = "";
        if (align.equals("center")) {

            for (int i = 0; i < ((WIDTH - string.length()) / 2); i++) {
                s = s + " ";
            }
            return s + string + s;
        }
        if (align.equals("left")){
            for (int i = 0; i < WIDTH - string.length(); i++) {
                s = s + " ";
            }
            return  string + s;
        }
        if (align.equals("right")){
            for (int i = 0; i < WIDTH - string.length(); i++) {
                s = s + " ";
            }
            return s + string;
        }
        return s;
    }

    private static String formatEdgedTwoStrings(String left, String right){
        if ((left.length() + right.length() >= WIDTH))
            return left + " " + right;
        String s = "";
        for (int i = 0; i < WIDTH - left.length() - right.length(); i++)
            s = s + " ";
        return left + s + right;
    }
    private static String formatLine(){
        String s = "";
        for (int i = 0; i < WIDTH; i++)
            s += "-";
        return s;
    }


}
