import java.util.Arrays;

public class TrainConsistManagementApp {

    // 🔹 Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // 🔸 Outer loop (passes)
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false; // optimization

            // 🔸 Inner loop (comparisons)
            for (int j = 0; j < n - i - 1; j++) {

                // 🔸 Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // 🔸 Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // 🔸 If no swaps → already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        // 🔸 Test Case 1: Unsorted array
        int[] capacities1 = {72, 56, 24, 70, 60};
        bubbleSort(capacities1);
        System.out.println("Sorted (Basic): " + Arrays.toString(capacities1));

        // 🔸 Test Case 2: Already sorted
        int[] capacities2 = {24, 56, 60, 70, 72};
        bubbleSort(capacities2);
        System.out.println("Sorted (Already Sorted): " + Arrays.toString(capacities2));

        // 🔸 Test Case 3: Duplicate values
        int[] capacities3 = {72, 56, 56, 24};
        bubbleSort(capacities3);
        System.out.println("Sorted (Duplicates): " + Arrays.toString(capacities3));

        // 🔸 Test Case 4: Single element
        int[] capacities4 = {50};
        bubbleSort(capacities4);
        System.out.println("Sorted (Single): " + Arrays.toString(capacities4));

        // 🔸 Test Case 5: All equal values
        int[] capacities5 = {40, 40, 40};
        bubbleSort(capacities5);
        System.out.println("Sorted (All Equal): " + Arrays.toString(capacities5));

        // 🔸 Program continues
        System.out.println("\nProgram execution continues...");
    }
}
