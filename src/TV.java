public class TV {
    private String name;
    private double price;
    private String additionalFeatures;

    public TV(String name, double price, String additionalFeatures) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }
}
