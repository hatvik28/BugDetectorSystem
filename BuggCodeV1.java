public class BuggCodeV1 {

  public static void main(String[] args) {

    String str = null;
    int length = (str != null) ? str.length() : 0;

    int[] numbers = {1, 2, 3};
    System.out.println(numbers[2]);

    Object obj = "hello";
    String str = (String) obj;
    System.out.println("String value: " + str);

    for (int i = 0; i < 5; i++) {
      System.out.println("Loop iteration: " + i);
    }

    final String text = "Buggy";
    if (text.length() > 10) {
      System.out.println(text.substring(10));
    } else {
      System.out.println("Substring index out of bounds");
    }

    if (1 == 2) {
      System.out.println("This code is unreachable!");
    }
  }
}
