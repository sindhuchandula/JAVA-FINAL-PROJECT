import java.util.*;
import java.io.*;

class Courier {
    int id;
    String sender, receiver, city, status;

    Courier(int id, String sender, String receiver,
            String city, String status) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.city = city;
        this.status = status;
    }

    void display() {
        System.out.println("\nCourier ID: " + id);
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("Destination: " + city);
        System.out.println("Status: " + status);
    }

    void updateStatus(String s) {
        if (s == null || s.trim().isEmpty())
            throw new IllegalArgumentException("Invalid status");

        status = s;
    }
}

public class CourierSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Courier> list = new ArrayList<>();

    static void showRoute(String[] route, int i) {
        if (i == route.length)
            return;

        System.out.println(route[i]);
        showRoute(route, i + 1);
    }

    public static void main(String[] args) throws IOException {
        int choice;

        do {
            System.out.println("\n--- COURIER TRACKING SYSTEM ---");
            System.out.println("1. Add Courier");
            System.out.println("2. Display Couriers");
            System.out.println("3. Update Status");
            System.out.println("4. Search Courier");
            System.out.println("5. Show Route");
            System.out.println("6. Sort Couriers");
            System.out.println("7. Save to File");
            System.out.println("8. Show Delivered Couriers");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Sender: ");
                    String sender = sc.nextLine();

                    System.out.print("Enter Receiver: ");
                    String receiver = sc.nextLine();

                    System.out.print("Enter Destination: ");
                    String city = sc.nextLine();

                    list.add(new Courier(id, sender, receiver,
                                         city, "Booked"));

                    System.out.println("Courier added successfully");
                    break;

                case 2:
                    for (Courier c : list)
                        c.display();
                    break;

                case 3:
                    System.out.print("Enter Courier ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    String status = sc.nextLine();

                    try {
                        boolean found = false;

                        for (Courier c : list) {
                            if (c.id == updateId) {
                                c.updateStatus(status);
                                System.out.println("Status updated");
                                found = true;
                                break;
                            }
                        }

                        if (!found)
                            System.out.println("Courier not found");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Courier ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Courier c : list) {
                        if (c.id == searchId) {
                            c.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Courier not found");
                    break;

                case 5:
                    String[] route = {
                        "Hyderabad", "Warangal", "Vijayawada"
                    };

                    System.out.println("Courier Route:");
                    showRoute(route, 0);
                    break;

                case 6:
                    list.sort((a, b) ->
                        a.city.compareToIgnoreCase(b.city));

                    System.out.println("Couriers sorted by destination");
                    break;

                case 7:
                    FileWriter fw = new FileWriter("courier.txt");

                    for (Courier c : list) {
                        fw.write(c.id + ", " + c.sender + ", "
                            + c.receiver + ", " + c.city + ", "
                            + c.status + "\n");
                    }

                    fw.close();
                    System.out.println("Data saved to courier.txt");
                    break;

                case 8:
                    list.stream()
                        .filter(c -> c.status.equalsIgnoreCase("Delivered"))
                        .forEach(c -> c.display());
                    break;

                case 0:
                    System.out.println("Exiting system");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}