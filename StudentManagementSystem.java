import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CrudApp {
    private List<User> userList = new ArrayList<>();
    private int nextId = 1;

    public void createUser(String name) {
        User user = new User(nextId, name);
        userList.add(user);
        nextId++;
        System.out.println("User created: " + user.getId() + ", " + user.getName());
    }

    public void readUsers() {
        System.out.println("User List:");
        for (User user : userList) {
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

    public void updateUser(int id, String newName) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(newName);
                System.out.println("User updated: " + user.getId() + ", " + user.getName());
                return;
            }
        }
        System.out.println("User not found with ID: " + id);
    }

    public void deleteUser(int id) {
        User userToRemove = null;
        for (User user : userList) {
            if (user.getId() == id) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            userList.remove(userToRemove);
            System.out.println("User deleted: " + userToRemove.getId() + ", " + userToRemove.getName());
        } else {
            System.out.println("User not found with ID: " + id);
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        CrudApp crudApp = new CrudApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Read Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    crudApp.createUser(name);
                    break;
                case 2:
                    crudApp.readUsers();
                    break;
                case 3:
                    System.out.print("Enter user ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new user name: ");
                    String newName = scanner.nextLine();
                    crudApp.updateUser(idToUpdate, newName);
                    break;
                case 4:
                    System.out.print("Enter user ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    crudApp.deleteUser(idToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
