package threads;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(new Product("Product 1", 10));

        Customer customer1 = new Customer("Customer 1", warehouse);
        Customer customer2 = new Customer("Customer 2", warehouse);
        Customer customer3 = new Customer("Customer 3", warehouse);

        customer1.start();
        customer2.start();
        customer3.start();
    }
}

