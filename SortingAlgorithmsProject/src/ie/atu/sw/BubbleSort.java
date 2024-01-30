package ie.atu.sw;

public class BubbleSort implements SortAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place, so no need to compare them again
            // Iterate through the unsorted part of the array
            for (int j = 0; j < n - i - 1; j++) {
                // Swap adjacent elements if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
