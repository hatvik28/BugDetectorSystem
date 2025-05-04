public class BuggyCodeV2 {

  public static void main(String[] args) {
    // 1. Null Pointer Exception
    String nullString = "Default String";
    System.out.println(nullString.length()); // Accessing a method on a null object

    // 2. Array Index Out of Bounds
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]); // Access the element at index 2

    // 3. Infinite Loop
    int i = 0;
    while (i >= 0 && i < 10) { // Added upper bound
      System.out.println("Loop iteration: " + i);
      i++; // Increment i to eventually exit the loop
    }

    // 4. StringIndexOutOfBoundsException
    String text = "Buggy";
    if (text.length() > 10) {
      System.out.println(text.substring(10));
    } else {
      System.out.println("Substring index is out of range.");
    }

    // 5. Logical Error
    if (1 == 2) { // Impossible condition
      System.out.println("This code is unreachable!");
    }
  }
}
