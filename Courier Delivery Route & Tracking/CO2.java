class CO2 {
    public static void main(String[] args) {
        String[] status = {"Booked", "In Transit", "Delivered"};

        for (int i = 0; i < status.length; i++) {
            System.out.println("Courier " + (i + 1) + ": " + status[i]);

            if (status[i].equals("Delivered")) {
                System.out.println("Delivery completed");
            } else {
                System.out.println("Delivery pending");
            }
        }
    }
}