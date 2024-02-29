package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {

        for (int j = index; j < products.length - 1; j++) {
            products[j] = products[j + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}