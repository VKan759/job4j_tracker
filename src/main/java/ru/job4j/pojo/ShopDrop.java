package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        int j;
        for (; index < products.length - 1; index++) {
            j = index + 1;
            products[index] = products[j];
        }
        products[products.length - 1] = null;
        return products;
    }
}