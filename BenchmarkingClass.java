import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;

public class BenchmarkingClass 
{
    private static Map<String, Long> executionTimes = new HashMap<>();

    public static void measureSortingAlgorithms(int[] array) {
        int[] userProvidedArray = getUserProvidedArray(array);

        SortingAlgorithmsClass sortingAlgorithms = new SortingAlgorithmsClass();

        int numberOfTrials = 10;

        benchmarkSortingAlgorithm("bubbleSort", userProvidedArray, numberOfTrials, sortingAlgorithms::bubbleSort);
        benchmarkSortingAlgorithm("selectionSort", userProvidedArray, numberOfTrials, sortingAlgorithms::selectionSort);
        benchmarkSortingAlgorithm("insertionSort", userProvidedArray, numberOfTrials, sortingAlgorithms::insertionSort);
        benchmarkSortingAlgorithm("mergeSort", userProvidedArray, numberOfTrials, sortingAlgorithms::mergeSort);
        benchmarkSortingAlgorithm("quickSort", userProvidedArray, numberOfTrials, sortingAlgorithms::quickSort);
        benchmarkSortingAlgorithm("heapSort", userProvidedArray, numberOfTrials, sortingAlgorithms::heapSort);
        benchmarkSortingAlgorithm("radixSort", userProvidedArray, numberOfTrials, sortingAlgorithms::radixSort);
        benchmarkSortingAlgorithm("shellSort", userProvidedArray, numberOfTrials, sortingAlgorithms::shellSort);
        benchmarkSortingAlgorithm("bucketSort", userProvidedArray, numberOfTrials, sortingAlgorithms::bucketSort);
        benchmarkSortingAlgorithm("countingSort", userProvidedArray, numberOfTrials, sortingAlgorithms::countingSort);

        // Other performance metrics measurement will be added in the future.
    }

    // Benchmark a single sorting algorithm
    private static void benchmarkSortingAlgorithm(String algorithmName, int[] array, int numberOfTrials, Consumer<int[]> sortingAlgorithm) {
        long totalTime = 0;

        for (int trial = 0; trial < numberOfTrials; trial++) {
            int[] arr = array.clone();

            long startTime = System.nanoTime();
            sortingAlgorithm.accept(arr);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            totalTime += duration;
        }

        long averageTime = totalTime / numberOfTrials;

        // Record and store the average time
        recordAndStorePerformanceMetrics(algorithmName, averageTime);
    }

    // getUserProvidedArray method
    private static int[] getUserProvidedArray(int[] userArray) {
        int[] providedArray = userArray.clone();
        return providedArray;
    }

    // recordAndStorePerformanceMetrics method
    private static void recordAndStorePerformanceMetrics(String algorithmName, long averageTime) {
        executionTimes.put(algorithmName, averageTime);
    }

    public static Map<String, Long> getExecutionTimes() {
        return executionTimes;
    }
}

// Other performance metrics measurement will be added in the future.
