import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void bubbleSort(ArrayList<Order> orders) {
        int n = orders.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).totalPrice > orders.get(j + 1).totalPrice) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no elements were swapped in the inner loop, then the list is already sorted
            if (!swapped) break;
        }
    }

    public static void quickSort(ArrayList<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);  // Before pi
            quickSort(orders, pi + 1, high); // After pi
        }
    }

    private static int partition(ArrayList<Order> orders, int low, int high) {
        double pivot = orders.get(high).totalPrice;
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (orders.get(j).totalPrice < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        // Swap orders[i+1] and orders[high] (or pivot)
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }
    public static void main(String[] args) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding some orders for demonstration purposes
        orders.add(new Order(1, "Alice", 200.50));
        orders.add(new Order(2, "Bob", 150.75));
        orders.add(new Order(3, "Charlie", 300.20));
        orders.add(new Order(4, "David", 100.10));

        System.out.println("Original Order List:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nOrder List After Bubble Sort by Total Price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Shuffle the list to demonstrate Quick Sort
        orders.add(new Order(5, "Eve", 250.30));
        orders.add(new Order(6, "Frank", 175.60));

        System.out.println("\nOrder List Before Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Quick Sort
        quickSort(orders, 0, orders.size() - 1);
        System.out.println("\nOrder List After Quick Sort by Total Price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
