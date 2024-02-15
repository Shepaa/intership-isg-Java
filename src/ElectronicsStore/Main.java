package ElectronicsStore;

import ElectronicsStore.basket.ShopBasket;
import ElectronicsStore.product.Laptop;

public class Main {
    public static void main(String[] args) {
        ShopBasket shopBasket = new ShopBasket();
        Laptop laptop = new Laptop("Mac", 46, "MacOS");

        shopBasket.addProduct(laptop);

        System.out.println(shopBasket.getTotalPrice());
        System.out.println(shopBasket.getBasket());
    }
}