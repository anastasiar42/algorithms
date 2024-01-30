package ie.atu.sw;

public class MergeSort implements SortAlgorithm {

    // Implementation of Merge Sort algorithm
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursive method to perform merge sort on the array
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // Recursively divide the left half of the array
            mergeSort(arr, left, mid);
            // Recursively divide the right half of the array
            mergeSort(arr, mid + 1, right);
            // Merge the two sorted halves of the array
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays into the original array
    public void merge(int[] arr, int left, int mid, int right) {
        // Calculate the sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the two subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy the elements of the left subarray into the first temporary array
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy the elements of the right subarray into the second temporary array
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the two subarrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of the left subarray into the original array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of the right subarray into the original array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
