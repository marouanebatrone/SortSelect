import java.util.Map;

public class AlgorithmSelectionClass 
{
    public static void main(String[] args) 
    {
        // Obtain execution times
        Map<String, Long> executionTimes = BenchmarkingClass.getExecutionTimes();

        String selectedAlgorithm = selectSortingAlgorithm(executionTimes);

        System.out.println("Selected Sorting Algorithm: " + selectedAlgorithm);
    }

    public  static String selectSortingAlgorithm(Map<String, Long> executionTimes) 
    {
        String selectedAlgorithm = null;
        long minExecutionTime = Long.MAX_VALUE;

        for (Map.Entry<String, Long> entry : executionTimes.entrySet()) 
        {
            String algorithm = entry.getKey();
            long executionTime = entry.getValue();

            if (executionTime < minExecutionTime) 
            {
                selectedAlgorithm = algorithm;
                minExecutionTime = executionTime;
            }
        }

        return selectedAlgorithm;
    }
}


// The selection criteria will be expanded in the future when additional performance metrics are added to BenchmarkingClass.