public class BuggyCodeV2 {

  public static void main(String[] args) {
    // 1. Null Pointer Exception
    String nullString = null;
    if (nullString != null) {
      System.out.println(nullString.length());
    } else {
      System.out.println("String is null");
    }

    // 2. Array Index Out of Bounds
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]); // Accessing the last valid index

    // 3. Infinite Loop
    int i = 0;
    while (i >= 0) { // Infinite loop as `i` is never decremented
      System.out.println("Infinite Loop!");
    }

    // 4. StringIndexOutOfBoundsException
    String text = "Buggy";
    System.out.println(text.substring(0, text.length())); // Correct range

    // 5. Logical Error
    if (1 == 2) { // Impossible condition
      System.out.println("This code is unreachable!");
    }
  }
}
