package ie.atu.sw;

public class InsertionSort implements SortAlgorithm {

    // Implementation of Insertion Sort algorithm
    public void sort(int[] arr) {
        int n = arr.length;

        // Iterate over each element starting from the second element
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Store the current element as the key
            int j = i - 1; // Set the initial index to the previous element

            // Shift elements greater than the key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Move the element to the right
                j--; // Decrement the index
            }

            arr[j + 1] = key; // Place the key at its correct position
        }
    }
}
