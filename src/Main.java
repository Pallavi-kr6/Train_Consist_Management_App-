// 🔹 Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 🔹 Passenger Bogie Class
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

        // 🔸 Fail-Fast Validation
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}

// 🔹 Main Application
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔸 Test Case 1: Valid Bogies
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 60);

            System.out.println("Valid Bogies:");
            System.out.println(b1);
            System.out.println(b2);

        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        // 🔸 Test Case 2: Negative Capacity
        try {
            PassengerBogie b3 = new PassengerBogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("\nException: " + e.getMessage());
        }

        // 🔸 Test Case 3: Zero Capacity
        try {
            PassengerBogie b4 = new PassengerBogie("Sleeper", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 🔸 Program continues safely
        System.out.println("\nProgram execution continues...");
    }
}
