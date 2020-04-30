import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    /**
     * Reads the input from the given InputStream splits it at the "," characters
     * and parses the splitted string's elements to Integer and gives back a
     * LinkedList with the these Integers
     * 
     * @param is the InputStream
     * @return an Integer LinkedList with the read elements
     */
    public static LinkedList<Integer> readInput(InputStream is) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        Scanner scanner = new Scanner(is);
        try {
            String input = scanner.nextLine();
            if (input != null && !(input.equals(""))) {
                String[] splitted = input.split(",");
                for (String string : splitted) {
                    nums.add(Integer.parseInt(string));
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            scanner.close();
        }
        return nums;
    }

    public static void main(String[] args) {
        SC sc = new SC(readInput(System.in));
        // Starting the Second Chance Algorithm
        sc.start();
        // Printing out the output and the number of the page faults
        System.out.println(sc);
    }
}