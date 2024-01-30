package ie.atu.sw;

import java.util.Arrays;

public class CountingSort implements SortAlgorithm {
    public void sort(int[] arr) {
        // Step 1: Find the maximum and minimum values in the array
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);

        // Step 2: Determine the range of values
        int range = max - min + 1;

        // Step 3: Create the count array and output array
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 4: Count the occurrences of each value
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 5: Calculate cumulative counts
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 6: Build the output array in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Step 7: Copy the sorted output array back to the input array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
