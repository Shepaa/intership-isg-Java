package StreamAPI.ProductCatalog;

import StreamAPI.Product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductCatalog {
    private List<Product> catalog;
    private final Scanner scanner;

    public ProductCatalog() {
        this.catalog = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void runApp() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    viewCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    sortCatalog();
                    break;
                case 5:
                    filterCatalog();
                    break;
                case 6:
                    createNewCatalog();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nSelect an action:");
        System.out.println("1. View catalog");
        System.out.println("2. Add product");
        System.out.println("3. Remove product");
        System.out.println("4. Sort catalog");
        System.out.println("5. Filter catalog");
        System.out.println("6. Create new catalog");
        System.out.println("7. Exit");
    }

    private int getValidChoice() {
        int choice = 0;
        while (choice < 1 || choice > 7) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
        return choice;
    }

    private void viewCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("\nProduct catalog:");
            catalog.forEach(System.out::println);
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        catalog.add(new Product(name));
        System.out.println("Product added successfully.");
    }

    private void removeProduct() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty. Nothing to remove.");
            return;
        }
        viewCatalog();
        System.out.print("Enter product index or name to remove: ");
        String input = scanner.nextLine();
        boolean removed = removeProductByIndexOrName(input);
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private boolean removeProductByIndexOrName(String input) {
        try {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < catalog.size()) {
                catalog.remove(index);
                return true;
            } else {
                System.out.println("Invalid index.");
                return false;
            }
        } catch (NumberFormatException e) {
            return catalog.removeIf(p -> p.getName().equalsIgnoreCase(input));
        }
    }

    private void sortCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty. Nothing to sort.");
            return;
        }
        System.out.println("\nSorted product catalog:");
        List<Product> sortedCatalog = catalog.stream()
                .sorted(Comparator.comparing(Product::getName))
                .toList();
        sortedCatalog.forEach(System.out::println);
    }

    private void filterCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty. Nothing to filter.");
            return;
        }
        System.out.print("Enter filter criteria (part of the name): ");
        String filter = scanner.nextLine().toLowerCase();
        System.out.println("\nFiltered product catalog:");
        List<Product> filteredCatalog = catalog.stream()
                .filter(p -> p.getName().toLowerCase().contains(filter))
                .toList();
        filteredCatalog.forEach(System.out::println);
    }

    private void createNewCatalog() {
        catalog = new ArrayList<>();
        System.out.println("New catalog created.");
    }
}