class Courier {
    private int id;
    private String status;

    Courier(int id, String status) {
        this.id = id;
        this.status = status;
    }

    void updateStatus(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid status");
        }
        status = s;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Status: " + status);
    }
}

class CO4 {
    public static void main(String[] args) {
        Courier c = new Courier(101, "Booked");

        try {
            c.updateStatus("In Transit");
            c.display();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}