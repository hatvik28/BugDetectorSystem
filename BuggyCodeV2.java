
public class BuggyCodeV2 {

  public static void main(String[] args) {
    // 1. Null Pointer Exception
    String nullString = null;
    System.out.println(nullString.length()); // Accessing a method on a null object

    // 2. Array Index Out of Bounds
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[3]); // Accessing index out of bounds

    // 3. Infinite Loop
    int i = 0;
    while (i >= 0) { // Infinite loop as `i` is never decremented
      System.out.println("Infinite Loop!");
      if (i == 10) { // Break condition to end the loop
        break;
      }
      i++;
    }

    // 4. StringIndexOutOfBoundsException
    String text = "Buggy";
    System.out.println(text.substring(10)); // Index out of range

    // 5. Logical Error
    if (1 == 2) { // Impossible condition
      System.out.println("This code is unreachable!");
    }
  }
}
