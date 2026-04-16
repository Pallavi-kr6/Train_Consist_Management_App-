import java.util.*;
import java.util.stream.Collectors;

// 🔹 Base Bogie Class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
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

        // 🔸 Step 1: Create list of bogies (reuse from UC7 concept)
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 65));

        // 🔸 Display original list
        System.out.println("Original Bogies:");
        bogies.forEach(System.out::println);

        // 🔸 Step 2: Stream + Filter (capacity > 60)
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // 🔸 Step 3: Display filtered result
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // 🔸 Verify original list unchanged
        System.out.println("\nOriginal List After Filtering (unchanged):");
        bogies.forEach(System.out::println);
    }
}
