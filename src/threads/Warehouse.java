package threads;

public class Warehouse {
    private final Product product;
    private final int initialQuantity;
    private int restockCount;
    private final int MAX_RESTOCKS = 3;

    public Warehouse(Product product) {
        this.product = product;
        this.initialQuantity = product.getQuantity();
    }
    public int getRestockCount() {
        return restockCount;
    }
     public int getMaxRestocks(){
        return MAX_RESTOCKS;
     }

    public void restock() {
        if (restockCount < MAX_RESTOCKS) {
            product.setQuantity(product.getQuantity() + 10);
            System.out.println("Restocked " + product.getName() + ". New quantity: " + product.getQuantity());
            restockCount++;
            notifyAll();
        } else {
            System.out.println("Warehouse is closed for restocking. Maximum restocks reached.");
        }
    }

    public synchronized boolean needRestock() {
        return product.getQuantity() < 0.2 * initialQuantity && restockCount < MAX_RESTOCKS;
    }

    public synchronized void sellProduct(Customer customer) throws InterruptedException {
        if (product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);
            System.out.println(customer.getName() + " bought " + product.getName() + ". Remaining quantity: " + product.getQuantity());
            if (product.getQuantity() < 0.2 * initialQuantity && restockCount < MAX_RESTOCKS) {
                restock();
            }
        } else {
            System.out.println("Sorry, " + customer.getName() + ", the warehouse is currently out of stock.");
        }
    }
}
