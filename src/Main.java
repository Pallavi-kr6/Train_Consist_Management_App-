import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // 🔸 Test Case 1: Basic unsorted input
        String[] bogies1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Arrays.sort(bogies1);
        System.out.println("Sorted (Basic): " + Arrays.toString(bogies1));

        // 🔸 Test Case 2: Unsorted input
        String[] bogies2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(bogies2);
        System.out.println("Sorted (Unsorted Input): " + Arrays.toString(bogies2));

        // 🔸 Test Case 3: Already sorted
        String[] bogies3 = {"AC Chair", "First Class", "General"};
        Arrays.sort(bogies3);
        System.out.println("Sorted (Already Sorted): " + Arrays.toString(bogies3));

        // 🔸 Test Case 4: Duplicate values
        String[] bogies4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(bogies4);
        System.out.println("Sorted (Duplicates): " + Arrays.toString(bogies4));

        // 🔸 Test Case 5: Single element
        String[] bogies5 = {"Sleeper"};
        Arrays.sort(bogies5);
        System.out.println("Sorted (Single): " + Arrays.toString(bogies5));

        // 🔸 Program continues
        System.out.println("\nProgram execution continues...");
    }
}
