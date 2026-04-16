// 🔹 Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 🔹 Passenger Bogie Class
class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

        // 🔸 Validation (Fail-Fast)
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}

// 🔹 Main App
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {
            // 🔸 Valid bogies
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 60);

            System.out.println("Valid Bogies Created:");
            System.out.println(b1);
            System.out.println(b2);

            // 🔸 Invalid bogie (negative capacity)
            PassengerBogie b3 = new PassengerBogie("First Class", -10);

        } catch (InvalidCapacityException e) {
            System.out.println("\nException Caught: " + e.getMessage());
        }

        try {
            // 🔸 Invalid bogie (zero capacity)
            PassengerBogie b4 = new PassengerBogie("Sleeper", 0);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // 🔸 Program continues safely
        System.out.println("\nProgram continues without invalid bogies.");
    }
}
