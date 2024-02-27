package threads;

public class Customer extends Thread {
    private String name;
    private final Warehouse warehouse;

    public Customer(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            if (warehouse.needRestock()) {
                warehouse.restock();
            } else {
                try {
                    warehouse.sellProduct(this);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (warehouse.getRestockCount() == warehouse.getMaxRestocks()) {
                break;
            }
        }
    }
}
