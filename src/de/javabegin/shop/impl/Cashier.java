/**
 * Cashier.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Jan-2023 14:09
 */

package de.javabegin.shop.impl;

import de.javabegin.shop.interfaces.ACashier;
import de.javabegin.shop.interfaces.IEmployee;
import de.javabegin.shop.interfaces.IShop;
import de.javabegin.shop.interfaces.Position;

public class Cashier implements IEmployee {
    private String name;

    /**
     * Должность
     */
    Position position;

    /**
     * Основной магазин, где работает продавец
     */
    IShop mainShop;

    public Cashier() {
    }

    public Cashier(String name, Position position, IShop mainShop) {
        this.name = name;
        this.position = position;
        this.mainShop = mainShop;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    public IShop getMainShop() {
        return mainShop;
    }
}
