import java.util.Scanner;

class task {
    String description;
    boolean completed;

    task(String description) {
        this.description = description;
        this.completed = false;
    }

    void markcompleted() {
        completed = true;
    }

    void showTask() {
        if (completed) {
            System.out.println(description + " - Done ");
        } else {
            System.out.println(description + " - Pending ");
        }
    }
}

public class todo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        task[] tasks = new task[5];
        int count = 0;

        while (true) {
            System.out.println("\n--- ToDo List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            if (choice == 1) {
                if (count < tasks.length) {
                    System.out.print("Enter Task Description: ");
                    String desc = sc.nextLine();
                    tasks[count] = new task(desc);
                    count++;
                    System.out.println("Task Added Successfully!");
                } else {
                    System.out.println("Task list is full! Please remove a task first.");
                }
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No tasks to remove.");
                } else {
                    System.out.println("\n--- Current Tasks ---");
                    for (int i = 0; i < count; i++) {
                        System.out.print((i + 1) + ". ");
                        tasks[i].showTask();
                    }
                    System.out.print("Enter the number of the task to remove: ");
                    int taskNumber = sc.nextInt();
                    if (taskNumber >= 1 && taskNumber <= count) {
                        for (int i = taskNumber - 1; i < count - 1; i++) {
                            tasks[i] = tasks[i + 1];
                        }
                        tasks[count - 1] = null; // Clear the last reference
                        count--;
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }
            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("No tasks to complete.");
                } else {
                    System.out.println("\n--- Current Tasks ---");
                    for (int i = 0; i < count; i++) {
                        System.out.print((i + 1) + ". ");
                        tasks[i].showTask();
                    }
                    System.out.print("Enter task number to mark completed: ");
                    int num = sc.nextInt();
                    if (num >= 1 && num <= count) {
                        tasks[num - 1].markcompleted();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Goodbye, have a nice day!");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}