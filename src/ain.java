import java.util.*;

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
        System.out.println("Original Bogies:");
        bogies.forEach(System.out::println);

        // 🔸 Step 2: Sort using Comparator (ascending)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // 🔸 Display sorted list
        System.out.println("\nSorted Bogies (Ascending by Capacity):");
        bogies.forEach(System.out::println);

        // 🔸 Step 3: Sort descending (optional but useful)
        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nSorted Bogies (Descending by Capacity):");
        bogies.forEach(System.out::println);
    }
}
