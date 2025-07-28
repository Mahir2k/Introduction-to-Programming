import java.util.Scanner;
import java.util.Random;

public class RemoveElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num[] = new int[10];
        int index, target;
        String answer = "";

        do {
            System.out.print("Random input 10 ints [0-9]: ");
            num = randomInput(10);
            String out = "The original array is: ";
            out += listArray(num);
            System.out.println(out);

            //deleting an element at a specific index using nested loops
            System.out.print("Enter the index to delete: ");
            index = scan.nextInt();

            if (index >= 0 && index < num.length) {
                int[] temp = new int[num.length - 1];
                for (int i = 0, j = 0; i < num.length; i++) {
                    if (i != index) {
                        temp[j] = num[i];
                        j++;
                    }
                }
                num = temp; //updating num to the new array with the element removed
                System.out.print("The array after deleting at index " + index + " is: ");
                System.out.println(listArray(num));
            } else {
                System.out.println("ERROR: array position is out of range.");
            }

            //removing all occurrences of target value using nested loops
            System.out.print("Enter the target value to remove: ");
            target = scan.nextInt();

            int count = 0;
            //using this first loop to count occurrences of elements not equal to target
            for (int i = 0; i < num.length; i++) {
                if (num[i] != target) {
                    count++;
                }
            }

            int[] result = new int[count];
            for (int i = 0, j = 0; i < num.length; i++) {
                if (num[i] != target) {
                    result[j] = num[i];
                    j++;
                }
            }
            num = result; //updating num to the new array with target elements removed
            System.out.print("The array after removing target " + target + " is: ");
            System.out.println(listArray(num));

            System.out.print("Go again? Enter 'y' or 'Y', anything else to quit- ");
            answer = scan.next();
        } while (answer.equals("Y") || answer.equals("y"));
    }

    public static int[] randomInput(int x) {
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = (int) (Math.random() * x);
        }
        return arr;
    }

    public static String listArray(int[] num) {
        String out = "{";
        for (int j = 0; j < num.length; j++) {
            if (j > 0) {
                out += ", ";
            }
            out += num[j];
        }
        out += "} ";
        return out;
    }
}
