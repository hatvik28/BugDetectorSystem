import java.util.ArrayList;
import java.util.List;

public class BuggCode {

    public static void main(String[] args) {

        String str = null;
        int length = str.length();
        


        int[] numbers = {1, 2, 3};
        System.out.println(numbers[3]); 

        

        Object obj = "hello";
        Integer num = (Integer) obj;



        public class ReturnIssue {
            public int getValue(int num) {
                if (num > 10) {
                    return num * 2;
                }
                // Missing return statement for when num <= 10
            }
        }


        
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
