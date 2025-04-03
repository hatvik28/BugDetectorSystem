public class BuggCode {

  public static void main(String[] args) {

    String str = "Hello World";
    int length = str.length();
    System.out.println(length);

    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]);

    int i = 0;
    while (i < 5) {
      System.out.println("Loop iteration: " + i);
      i++;
    }

    String text = "Buggy";
    System.out.println(text.substring(0));

    if (1 == 2) {
      System.out.println("This code is unreachable!");
    }
  }
}
