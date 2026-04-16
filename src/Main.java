import java.util.*;
import java.util.stream.Collectors;

// 🔹 Bogie Class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Capacity: " + capacity;
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
        System.out.println("Original Bogies:");
        bogies.forEach(b -> System.out.println(b.name + " -> " + b.capacity));

        // 🔸 Step 2: Group using Stream + groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 🔸 Step 3: Display grouped result
        System.out.println("\nGrouped Bogies by Type:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity: " + b.capacity);
            }
        }

        // 🔸 Verify original list unchanged
        System.out.println("\nOriginal List After Grouping (unchanged):");
        bogies.forEach(b -> System.out.println(b.name + " -> " + b.capacity));
    }
}
