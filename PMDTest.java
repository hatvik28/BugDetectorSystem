import java.util.Random;

public class PMDTest {

    public static void main(String[] args) {
        // Null assignment (may lead to NullPointerException)
        String name = null;
        if (name != null && name.equals("PMD")) {  // Fixed NullPointerException by adding null check
            System.out.println("Name matches PMD");
        }

        // Inefficient string concatenation in a loop
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            result.append(i).append(", ");  // Using StringBuilder to improve efficiency
        }
        System.out.println(result);

        // ArrayIndexOutOfBoundsException
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[5]);  // This line will throw an ArrayIndexOutOfBoundsException
     
     

        // Avoid instantiating new objects inside a loop (PMD warning)
        Random random = new Random();  // Moved instantiation outside the loop
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }

        // Open stream without closing it (resource leak)
        try (java.io.FileInputStream fileStream = new java.io.FileInputStream("example.txt")) {
            System.out.println("File opened successfully");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
