import java.util.Arrays;

public class TrainConsistManagementApp {

    // 🔹 Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        // 🔸 Handle empty array
        if (bogieIds.length == 0) return false;

        // 🔸 Ensure array is sorted (important precondition)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        // 🔸 Binary Search Loop
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true; // 🔸 Found
            } else if (comparison < 0) {
                low = mid + 1; // 🔸 Search right
            } else {
                high = mid - 1; // 🔸 Search left
            }
        }

        return false; // 🔸 Not found
    }

    public static void main(String[] args) {

        // 🔸 Test Case 1: Found
        String[] bogies1 = {"BG101","BG205","BG309","BG412","BG550"};
        System.out.println("Search BG309: " + binarySearch(bogies1, "BG309"));

        // 🔸 Test Case 2: Not Found
        System.out.println("Search BG999: " + binarySearch(bogies1, "BG999"));

        // 🔸 Test Case 3: First element
        System.out.println("Search BG101: " + binarySearch(bogies1, "BG101"));

        // 🔸 Test Case 4: Last element
        System.out.println("Search BG550: " + binarySearch(bogies1, "BG550"));

        // 🔸 Test Case 5: Single element
        String[] single = {"BG101"};
        System.out.println("Search BG101 in single: " + binarySearch(single, "BG101"));

        // 🔸 Test Case 6: Empty array
        String[] empty = {};
        System.out.println("Search in empty array: " + binarySearch(empty, "BG101"));

        // 🔸 Test Case 7: Unsorted input
        String[] unsorted = {"BG309","BG101","BG550","BG205","BG412"};
        System.out.println("Search BG205 in unsorted: " + binarySearch(unsorted, "BG205"));

        // 🔸 Program continues
        System.out.println("\nProgram execution continues...");
    }
}
