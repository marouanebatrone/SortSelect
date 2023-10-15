import java.util.function.Consumer;
public class SortingAlgorithmsClass
{
    
    // Bubble Sort
    public void bubbleSort(int[] arr) 
    {
        int n = arr.length;
        boolean swapped;
        do 
        {
            swapped = false;
            for (int i = 1; i < n; i++) 
            {
                if (arr[i - 1] > arr[i]) 
                {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } 
        while (swapped);
    }

    // Selection Sort
    public void selectionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion Sort
    public void insertionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) 
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public void mergeSort(int[] arr) 
    {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right) 
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++) 
        {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) 
        {
            rightArr[i] = arr[middle + 1 + i];
        }
        
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) 
        {
            if (leftArr[i] <= rightArr[j]) 
            {
                arr[k] = leftArr[i];
                i++;
            } 
            else 
            {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) 
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) 
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public void quickSort(int[] arr) 
    {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) 
    {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (arr[j] < pivot) 
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Heap Sort
    public void heapSort(int[] arr) 
    {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) 
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) 
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) 
        {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) 
        {
            largest = right;
        }

        if (largest != i) 
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Radix Sort
    public void radixSort(int[] arr) 
    {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) 
        {
            countingSortByDigit(arr, exp);
        }
    }

    private int getMax(int[] arr) 
    {
        int max = arr[0];
        for (int num : arr) 
        {
            if (num > max) 
            {
                max = num;
            }
        }
        return max;
    }

    private void countingSortByDigit(int[] arr, int exp) 
    {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < 10; i++) 
        {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) 
        {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) 
        {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) 
        {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    // Shell Sort
    public void shellSort(int[] arr) 
    {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) 
        {
            for (int i = gap; i < n; i++) 
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // Bucket Sort
    public void bucketSort(int[] arr) 
    {
        int n = arr.length;
        if (n <= 0) 
        {
            return;
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) 
        {
            if (arr[i] > max) 
            {
                max = arr[i];
            }
            if (arr[i] < min) 
            {
                min = arr[i];
            }
        }

        int bucketCount = max - min + 1;
        int[] buckets = new int[bucketCount];

        for (int i = 0; i < n; i++) 
        {
            buckets[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) 
        {
            for (int j = 0; j < buckets[i]; j++) 
            {
                arr[index++] = i + min;
            }
        }
    }


    // Counting Sort
    public void countingSort(int[] arr) 
    {
        int n = arr.length;
        if (n <= 1) 
        {
            return; 
        }

        int max = findMax(arr);

        int[] countArray = new int[max + 1];

        for (int num : arr) 
        {
            countArray[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) 
        {
            while (countArray[i] > 0) 
            {
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }
    }

    private int findMax(int[] arr) 
    {
        int max = arr[0];
        for (int num : arr) 
        {
            if (num > max) 
            {
                max = num;
            }
        }
        return max;
    }

    // Comb Sort
    public void combSort(int[] arr) 
    {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap > 1 || swapped) 
        {
            gap = getNextGap(gap);

            swapped = false;

            for (int i = 0; i < n - gap; i++) 
            {
                if (arr[i] > arr[i + gap]) 
                {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) 
    {
        gap = (gap * 10) / 13;
        if (gap < 1) 
        {
            return 1;
        }
        return gap;
    }

    // Pancake Sort
    public void pancakeSort(int[] arr) 
    {
        int n = arr.length;
        for (int currSize = n; currSize > 1; currSize--) 
        {
            int maxIndex = findMaxIndex(arr, currSize);

            if (maxIndex != currSize - 1) 
            {
                flip(arr, maxIndex);
                flip(arr, currSize - 1);
            }
        }
    }

    private int findMaxIndex(int[] arr, int n) 
    {
        int maxIndex = 0;
        for (int i = 0; i < n; i++) 
        {
            if (arr[i] > arr[maxIndex]) 
            {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void flip(int[] arr, int i) 
    {
        int start = 0;
        while (start < i) 
        {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    // (More sorting algorithms will be added in the future)
}
