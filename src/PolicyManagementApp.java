import java.util.Scanner;

public class PolicyManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PolicyManager manager = new PolicyManager();

        while (true) {
            System.out.println("\n1. Add Policy");
            System.out.println("2. Remove Policy");
            System.out.println("3. Update Policy");
            System.out.println("4. List Policies by Type");
            System.out.println("5. List All Policies");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Policy Number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Insurance Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Coverage Amount: ");
                    double amount = scanner.nextDouble();
                    manager.addPolicy(new Policy(number, name, type, amount));
                }
                case 2 -> {
                    System.out.print("Enter Policy Number to remove: ");
                    int number = scanner.nextInt();
                    manager.removePolicyByNumber(number);
                }
                case 3 -> {
                    System.out.print("Enter Policy Number to update: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Insurance Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter New Coverage Amount: ");
                    double amount = scanner.nextDouble();
                    manager.updatePolicy(number, name, type, amount);
                }
                case 4 -> {
                    System.out.print("Enter Insurance Type: ");
                    scanner.nextLine();
                    String type = scanner.nextLine();
                    manager.listPoliciesByType(type);
                }
                case 5 -> manager.listAllPolicies();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}