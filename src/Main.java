import java.util.*;
import java.util.stream.*;

// 🔹 Bogie Class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + name + ", Capacity: " + capacity;
    }
}

// 🔹 Main App
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔸 Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 65));

        // 🔸 Display original list
        System.out.println("Bogies:");
        bogies.forEach(System.out::println);

        // 🔸 Step 2: Stream → map → reduce
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);      // sum all values

        // 🔸 Display total
        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        // 🔸 Verify original list unchanged
        System.out.println("\nOriginal List After Aggregation (unchanged):");
        bogies.forEach(System.out::println);
    }
}
