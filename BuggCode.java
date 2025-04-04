import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class BuggCode {

  public static void main(String[] args) {

    String str = null;
    System.out.println(str);

    int[] numbers = {1, 2, 3};
     
    System.out.println(numbers[2]);
    
    int i = 0;
    while (i < 5) {
      System.out.println("Loop iteration: " + i);
      i++;
    }
 
    String text = "Buggy";
    System.out.println(text);

    if (1 == 2) {
      System.out.println("This code is unreachable!");
    }
  }
}
