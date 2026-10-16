class CO3 {
    static void showRoute(String[] route, int i) {
        if (i == route.length)
            return;

        System.out.println(route[i]);
        showRoute(route, i + 1);
    }

    public static void main(String[] args) {
        String[] route = {"Hyderabad", "Warangal", "Vijayawada"};

        System.out.println("Courier Route:");
        showRoute(route, 0);
    }
}