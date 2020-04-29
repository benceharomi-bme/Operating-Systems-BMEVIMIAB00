import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

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

    public static void printOutput() {

    }

    public static void main(String[] args) {
        MMU m = new MMU(readInput(System.in));
        System.out.println(m.start());
        System.out.println(m.numOfErrors);
    }
}