import java.util.Random;



public class PMDTest {

    public static void main(String[] args) {

        // Null assignment leading to potential NullPointerException

        String name = null;

        if (name.equals("PMD")) {  // This line can throw a NullPointerException

            System.out.println("Name matches PMD");

        }

        //Array Index out of bounds

        int[] array = {1,2,3,4};

        System.out.println(array[6]);


        int[] arr = {1, 2, 3};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
