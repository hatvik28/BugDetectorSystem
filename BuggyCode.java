public class BuggyCode {
    
    // This line is too long, exceeding 120 characters, which violates common Java style guides and makes it difficult to read and maintain.
    private String longString = "This is a very long string that goes way beyond the recommended line length and should be split into multiple lines for readability"; 
    
    public static void main(String[] args) {
        System.out.println("This is an example of buggy Java code"); // Missing semicolon at the end
        
        int result = addNumbers(5, 10);
        System.out.println("Result: " + result);
        
        System.out.println(undefinedVariable); // Undefined variable error

        System.out.println("This string is not closed properly); // Syntax error: unclosed string
    }

    public static int addNumbers(int a, int b) {
        if (a > 0) {
            return a + b;
        } else {
            System.out.println("Negative number"); // Inconsistent return statement: No return in this case
        }
    }
}
