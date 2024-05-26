import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int id;
    private String description;
    private boolean isCompleted;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}

public class TodoApp {
    private static List<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTodo App");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsCompleted(scanner);
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.next();
        Task task = new Task(nextId++, description);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.markAsCompleted();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void listTasks() {
        System.out.println("\nTasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
