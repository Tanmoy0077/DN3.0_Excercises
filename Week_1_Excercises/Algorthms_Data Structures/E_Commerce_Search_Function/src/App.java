import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Product> inventory = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Product");
            System.out.println("4. View All Products");
            System.out.println("5. Linear Search");
            System.out.println("6. Binary Search");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    deleteProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    linearSearch(scanner);
                    break;
                case 6:
                    binarySearch(scanner);
                    break;
                case 7:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
    public static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        int price = scanner.nextInt();

        Product product = new Product(productId, productName, quantity, price);
        inventory.add(product);
        System.out.println("Product added successfully!");
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to delete: ");
        int productId = scanner.nextInt();

        Product productToDelete = null;
        for (Product product : inventory) {
            if (product.productId == productId) {
                productToDelete = product;
                break;
            }
        }
        if (productToDelete != null) {
            inventory.remove(productToDelete);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();

        Product productToUpdate = null;
        for (Product product : inventory) {
            if (product.productId == productId) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate != null) {
            System.out.print("Enter new Product Name: ");
            scanner.nextLine();  // Consume newline
            String productName = scanner.nextLine();
            System.out.print("Enter new Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter new Price: ");
            int price = scanner.nextInt();

            productToUpdate.productName = productName;
            productToUpdate.quantity = quantity;
            productToUpdate.price = price;
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }
    public static void viewAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }

    public static void linearSearch(Scanner scanner) {
        System.out.print("Enter Product ID to search: ");
        int productId = scanner.nextInt();

        for (Product product : inventory) {
            if (product.productId == productId) {
                System.out.println("Product found: " + product);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public static void binarySearch(Scanner scanner) {
        System.out.print("Enter Product ID to search: ");
        int productId = scanner.nextInt();

        int left = 0;
        int right = inventory.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = inventory.get(mid);

            if (midProduct.productId == productId) {
                System.out.println("Product found: " + midProduct);
                return;
            }

            if (midProduct.productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Product not found!");
    }

}
