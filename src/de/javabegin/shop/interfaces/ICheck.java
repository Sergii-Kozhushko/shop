package de.javabegin.shop.interfaces;

import de.javabegin.shop.impl.Cashier;
import de.javabegin.shop.impl.DiscountCard;
import de.javabegin.shop.impl.Product;
import de.javabegin.shop.impl.ProductInCheck;

import java.util.ArrayList;

public interface ICheck {
    IShop getShop();

    /**
     * Кассир, который выписал чек
     * @return
     */
    Cashier getCashier();

    /**
     * Номер чека
     * @return
     */
    String getNumber();

    /**
     * Товары в чеке
     * @return
     */
    ArrayList<ProductInCheck> getProductList();

    /**
     * Добавить товар в чек  в конец
     */
    void addProduct(ProductInCheck product);

    /**
     * Дисконтная карта в чеке, если есть
     * @return
     */
    DiscountCard getDiscountCard();

    /**
     * Печать чека, бизнес-метод
     */
    void print();

}
