import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class MainClass 
{
    public static void main(String[] args) 
    {
        int[] userProvidedArray = UserInterfaceClass.getUserInput();

        // We pass the userProvidedArray to the BenchmarkingClass for performance benchmarking
        BenchmarkingClass.measureSortingAlgorithms(userProvidedArray);

        // We use AlgorithmSelectionClass to select the most suitable sorting algorithm
        String selectedAlgorithm = AlgorithmSelectionClass.selectSortingAlgorithm(BenchmarkingClass.getExecutionTimes());

        String methodName = selectedAlgorithm.replace(" ", "");


        try 
        {
            Class<?> sortingAlgorithmsClass = Class.forName("SortingAlgorithmsClass");
            Method sortingMethod = sortingAlgorithmsClass.getMethod(methodName, int[].class);
            SortingAlgorithmsClass sortingAlgorithm = new SortingAlgorithmsClass();
            sortingMethod.invoke(sortingAlgorithm, userProvidedArray);
        } 
        catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) 
        {
            e.printStackTrace();
        }

        System.out.println("Selected Sorting Algorithm: " + selectedAlgorithm);
        System.out.print("Sorted Array: ");
        for (int num : userProvidedArray) 
        {
            System.out.print(num + " ");
        }
    }
}
