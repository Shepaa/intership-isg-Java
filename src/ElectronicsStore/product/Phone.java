package ElectronicsStore.product;

public class Phone implements ElectronicProduct {
    private final String name;
    private final double price;
    private final String additionalFeatures;

    public Phone(String name, double price, String additionalFeatures) {
        this.name = name;
        this.price = price;
        this.additionalFeatures = additionalFeatures;
    }

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
