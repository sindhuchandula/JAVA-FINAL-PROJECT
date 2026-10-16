import java.util.ArrayList;

class CO6 {
    public static void main(String[] args) {
        ArrayList<String> couriers = new ArrayList<>();

        couriers.add("101-Booked");
        couriers.add("102-Delivered");
        couriers.add("103-Delivered");
        couriers.add("104-In Transit");

        System.out.println("All Couriers:");
        couriers.forEach(c -> System.out.println(c));

        System.out.println("Delivered Couriers:");
        couriers.stream()
                .filter(c -> c.contains("Delivered"))
                .forEach(c -> System.out.println(c));
    }
}