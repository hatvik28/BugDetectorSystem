import java.util.ArrayList;
import java.util.List;

public class BuggyCode {
    public static void main(String[] args) {
        // 1. Null Pointer Exception
        String nullString = null;
        System.out.println(nullString.length()); // Accessing a method on a null object

        // 2. Array Index Out of Bounds
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[3]); // Accessing index out of bounds

        // 3. Infinite Loop
        int i = 0;
        while (i >= 0) {
        System.out.println("Infinite Loop!"); // i is never decremented
        }

        // 4. StringIndexOutOfBoundsException
        try {
            String text = "Buggy";
            System.out.println(text.substring(10)); // Index out of range
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }

        System.err.println();
    }



}
