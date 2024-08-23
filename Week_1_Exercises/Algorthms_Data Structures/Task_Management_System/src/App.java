import java.util.Scanner;

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class App {
    private Node head;
    public static void main(String[] args) {
        App taskManagement = new App();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taskManagement.addTask(scanner);
                    break;
                case 2:
                    taskManagement.searchTask(scanner);
                    break;
                case 3:
                    taskManagement.traverseTasks();
                    break;
                case 4:
                    taskManagement.deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public void addTask(Scanner scanner) {
        System.out.print("Enter Task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter Task Status: ");
        String status = scanner.nextLine();

        Task task = new Task(taskId, taskName, status);
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added successfully!");
    }

    public void searchTask( Scanner scanner) {
        System.out.print("Enter Task ID to search: ");
        int taskId = scanner.nextInt();

        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                System.out.println("Task found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found!");
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public void deleteTask( Scanner scanner) {
        System.out.print("Enter Task ID to delete: ");
        int taskId = scanner.nextInt();

        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully!");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found!");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted successfully!");
        }
    }
}
