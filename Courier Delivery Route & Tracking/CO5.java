import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

class CO5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] cities = {"Warangal", "Hyderabad", "Vijayawada"};

        Arrays.sort(cities);

        System.out.println("Sorted Cities: " + Arrays.toString(cities));

        System.out.print("Enter city to search: ");
        String city = sc.nextLine();

        if (Arrays.binarySearch(cities, city) >= 0)
            System.out.println("Courier destination found");
        else
            System.out.println("Destination not found");

        FileWriter fw = new FileWriter("courier.txt");
        fw.write("Courier destination: " + city);
        fw.close();

        System.out.println("Details saved to courier.txt");

        sc.close();
    }
}