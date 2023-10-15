import java.util.Scanner;

public class UserInterfaceClass 
{
    public static int[] getUserInput() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] inputArray = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) 
        {
            System.out.print("Element " + (i + 1) + ": ");
            inputArray[i] = scanner.nextInt();
        }

        scanner.close();

        return inputArray;
    }
}
