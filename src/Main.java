public class TrainConsistManagementApp {

    // 🔹 Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        // 🔸 Traverse array
        for (int i = 0; i < bogieIds.length; i++) {

            // 🔸 Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // 🔸 Found → early exit
            }
        }

        return false; // 🔸 Not found after full traversal
    }

    public static void main(String[] args) {

        // 🔸 Sample bogie IDs (unsorted)
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 🔸 Test Case 1: Found in middle
        System.out.println("Search BG309: " + linearSearch(bogies, "BG309"));

        // 🔸 Test Case 2: Not found
        System.out.println("Search BG999: " + linearSearch(bogies, "BG999"));

        // 🔸 Test Case 3: First element
        System.out.println("Search BG101: " + linearSearch(bogies, "BG101"));

        // 🔸 Test Case 4: Last element
        System.out.println("Search BG550: " + linearSearch(bogies, "BG550"));

        // 🔸 Test Case 5: Single element array
        String[] single = {"BG101"};
        System.out.println("Search BG101 in single array: " + linearSearch(single, "BG101"));

        // 🔸 Program continues
        System.out.println("\nProgram execution continues...");
    }
}
