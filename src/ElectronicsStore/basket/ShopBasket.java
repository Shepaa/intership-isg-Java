package ElectronicsStore.basket;

import ElectronicsStore.product.ElectronicProduct;

import java.util.ArrayList;

public class ShopBasket implements IShopBasket {
    private final ArrayList<ElectronicProduct> basket = new ArrayList<>();

    public void addProduct(ElectronicProduct product) {
        this.basket.add(product);
    }

    public ArrayList<String> getBasket() {
        ArrayList<String> productNames = new ArrayList<>();
        basket.forEach(product -> productNames.add(product.getName()));
        return productNames;
    }


    public int getTotalPrice() {
        int totalPrice = 0;
        for (ElectronicProduct product : basket) {
            totalPrice += (int) product.getPrice();
        }
        return totalPrice;
    }
}
