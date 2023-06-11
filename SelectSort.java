import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
* Program finds a number using insertion sort.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-09
*/

public final class SelectSort {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private SelectSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Take from the input file.
        final File input = new File("input.txt");

        // Display in the output file.
        final File output = new File("output.txt");

        // Create a list to store the input lines.
        final List<String> inputLines = new ArrayList<>();

        try {

            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            // Read the input file line by
            // Line and add each line to the list.
            while (sc.hasNextLine()) {
                // Read next line as a string
                final String line = sc.nextLine();

                // Add to list.
                inputLines.add(line);
            }

            // Convert from list to array.
            final String[] arrayOfStr = inputLines.toArray(new String[0]);

            // Process each line in the input file.
            for (int counter = 0; counter < arrayOfStr.length; counter++) {

                try {
                    // Split the string into individual numbers
                    final String[] nums = arrayOfStr[counter].split(" ");

                    // Create an array to store the converted integers
                    final int[] arrayNum = new int[nums.length];

                    for (int counter2 = 0; counter2 < nums.length; counter2++) {
                        // Convert each string to an
                        // Integer and store it in the array
                        arrayNum[counter2] = Integer.parseInt(nums[counter2]);
                    }

                    // Call the selectSort function to sort the array
                    final int[] sortSelect = selectSort(arrayNum);

                    // Display the sorted array and write it to the output file
                    System.out.println(Arrays.toString(sortSelect));
                    write.println(Arrays.toString(sortSelect));

                } catch (NumberFormatException error) {
                    // Handle errors for incorrect or invalid input
                    System.out.println("Incorrect, valid input.");
                    write.println("Incorrect, valid input.");
                    continue;
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }

    /**
    * This function uses bubble sort to
    * sort an array.
    * Video reference.
    *
    * @param listNum passed.
    * @return listNum.
    */
    public static int[] selectSort(int[] listNum) {
        // Iterate over each element using a loop

        for (int counter1 = 0; counter1 < listNum.length; counter1++) {
            // Initialize the index of the
            // Minimum element as the current index
            int minIndex = counter1;

            // Find the index of the minimum element
            // By iterating over the remaining elements
            for (int counter2 = counter1 + 1;
                    counter2 < listNum.length; counter2++) {
                // Compare the current
                // Element with the minimum element
                if (listNum[counter2] < listNum[minIndex]) {
                    // If a smaller element is found,
                    // Update the index of the minimum element
                    minIndex = counter2;
                }
            }

            // Check if the minimum element is at a
            // Different index than the current element
            if (minIndex != counter1) {
                // Swap the current element with the minimum element
                final int temp = listNum[counter1];
                listNum[counter1] = listNum[minIndex];
                listNum[minIndex] = temp;
            }
        }
        // Return the sorted array
        return listNum;
    }
}

