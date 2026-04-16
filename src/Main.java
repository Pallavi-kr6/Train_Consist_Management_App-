import java.util.*;

// 🔹 Goods Bogie Class
class GoodsBogie {
    String type;   // Cylindrical, Open, Box
    String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Cargo: " + cargo;
    }
}

// 🔹 Main App
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔸 Step 1: Create list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // 🔸 Display bogies
        System.out.println("Goods Bogies:");
        bogies.forEach(System.out::println);

        // 🔸 Step 2: Safety check using allMatch()
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
                );

        // 🔸 Step 3: Display result
        System.out.println("\nSafety Compliance Status: " + (isSafe ? "SAFE" : "UNSAFE"));

        // 🔸 Test case: introduce violation
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafeAfterViolation = bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
                );

        System.out.println("After adding invalid bogie: " +
                (isSafeAfterViolation ? "SAFE" : "UNSAFE"));
    }
}
