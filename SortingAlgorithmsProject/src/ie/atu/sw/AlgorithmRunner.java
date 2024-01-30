package ie.atu.sw;


public class AlgorithmRunner {
    public static void main(String[] args) {
        int[] inputSizes = {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};

        // Algorithms
        SortAlgorithm[] algorithms = {
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new CountingSort(),
                new MergeSort()
        };

        // Output table header
        System.out.print("Size\t\t");
        for (int size : inputSizes) {
            System.out.print(size + "\t\t");
        }
        System.out.println();

        // Run algorithms and print results
        for (SortAlgorithm algorithm : algorithms) {
            System.out.print(algorithm.getClass().getSimpleName() + "\t");

            for (int size : inputSizes) {
                long totalElapsedTime = 0;

                for (int i = 0; i < 10; i++) {
                    int[] arr = generateRandomArray(size);

                    long startTime = System.nanoTime();
                    algorithm.sort(arr);
                    long endTime = System.nanoTime();

                    totalElapsedTime += (endTime - startTime);
                }

                double averageElapsedTimeMs = totalElapsedTime / 10_000_000.0 / 10.0;
                System.out.printf("%.3f\t\t", averageElapsedTimeMs);
            }

            System.out.println();
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}
