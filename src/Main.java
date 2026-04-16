import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

// -------------------- CUSTOM EXCEPTIONS --------------------
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// -------------------- BOGIE CLASSES --------------------
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}

// Goods Bogie
class GoodsBogie {
    String type; // Rectangular / Cylindrical
    String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Petroleum cannot be in Rectangular bogie");
            }
            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo + " to " + type);
        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Assignment attempt completed.\n");
        }
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

// -------------------- MAIN APP --------------------
public class TrainApp {

    public static void main(String[] args) {

        try {
            // ---------------- UC7: SORT USING COMPARATOR ----------------
            List<Bogie> bogies = new ArrayList<>();
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));

            System.out.println("\n--- UC7: Sorted Bogies ---");
            bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
            bogies.forEach(System.out::println);

            // ---------------- UC8: FILTER USING STREAM ----------------
            System.out.println("\n--- UC8: Filter Capacity > 60 ---");
            List<Bogie> filtered = bogies.stream()
                    .filter(b -> b.capacity > 60)
                    .toList();
            filtered.forEach(System.out::println);

            // ---------------- UC9: GROUPING ----------------
            System.out.println("\n--- UC9: Group by Type ---");
            Map<String, List<Bogie>> grouped =
                    bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
            grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

            // ---------------- UC10: REDUCE ----------------
            System.out.println("\n--- UC10: Total Capacity ---");
            int total = bogies.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);
            System.out.println("Total Seats: " + total);

            // ---------------- UC11: REGEX VALIDATION ----------------
            System.out.println("\n--- UC11: Regex Validation ---");
            String trainId = "TRN-1234";
            String cargoCode = "PET-AB";

            boolean validTrain = Pattern.matches("TRN-\\d{4}", trainId);
            boolean validCargo = Pattern.matches("PET-[A-Z]{2}", cargoCode);

            System.out.println("Train ID valid: " + validTrain);
            System.out.println("Cargo Code valid: " + validCargo);

            // ---------------- UC12: SAFETY CHECK ----------------
            System.out.println("\n--- UC12: Safety Check ---");
            List<GoodsBogie> goods = new ArrayList<>();
            goods.add(new GoodsBogie("Cylindrical"));
            goods.add(new GoodsBogie("Rectangular"));

            goods.get(0).assignCargo("Petroleum");
            goods.get(1).assignCargo("Coal");

            boolean safe = goods.stream().allMatch(g ->
                    !g.getType().equalsIgnoreCase("Cylindrical") ||
                            g.getCargo().equalsIgnoreCase("Petroleum")
            );
            System.out.println("Train Safe: " + safe);

            // ---------------- UC16: BUBBLE SORT ----------------
            System.out.println("\n--- UC16: Bubble Sort ---");
            int[] arr = {72, 56, 24, 70, 60};

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));

            // ---------------- UC17: ARRAY SORT ----------------
            System.out.println("\n--- UC17: Arrays.sort() ---");
            String[] names = {"Sleeper", "AC Chair", "First Class", "General"};
            Arrays.sort(names);
            System.out.println(Arrays.toString(names));

            // ---------------- UC18: LINEAR SEARCH ----------------
            System.out.println("\n--- UC18: Linear Search ---");
            String[] ids = {"BG101", "BG205", "BG309", "BG412"};
            String key = "BG309";

            boolean found = false;
            for (String id : ids) {
                if (id.equals(key)) {
                    found = true;
                    break;
                }
            }
            System.out.println("Found: " + found);

            // ---------------- UC19: BINARY SEARCH ----------------
            System.out.println("\n--- UC19: Binary Search ---");
            Arrays.sort(ids); // ensure sorted
            int low = 0, high = ids.length - 1;
            boolean foundBinary = false;

            while (low <= high) {
                int mid = (low + high) / 2;
                int cmp = ids[mid].compareTo(key);

                if (cmp == 0) {
                    foundBinary = true;
                    break;
                } else if (cmp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println("Found: " + foundBinary);

            // ---------------- UC20: FAIL FAST ----------------
            System.out.println("\n--- UC20: Fail Fast Search ---");
            String[] empty = {};

            if (empty.length == 0) {
                throw new IllegalStateException("No bogies available for search");
            }

        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}
