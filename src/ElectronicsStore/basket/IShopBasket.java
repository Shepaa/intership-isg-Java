package ElectronicsStore.basket;

import ElectronicsStore.product.ElectronicProduct;

import java.util.ArrayList;

public interface IShopBasket {
    void addProduct(ElectronicProduct product);
    ArrayList<String> getBasket();
    int getTotalPrice();
}
