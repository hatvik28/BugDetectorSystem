public class BuggCode {

  public static void main(String[] args) {

    String str = "Hello World";
    int length = str.length();
    System.out.println(length);

    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]);

    Object obj = "hello";
    Integer num = (Integer) obj;

    int i = 0;
    while (i >= 0) {
      System.out.println("Infinite Loop!");
    }

    String text = "Buggy";
    System.out.println(text.substring(10));

    if (1 == 2) {
      System.out.println("This code is unreachable!");
    }
  }
}
