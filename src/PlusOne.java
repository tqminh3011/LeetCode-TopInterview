import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// Examples
// 6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3 -> 6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,4
// 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 -> 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
public class PlusOne {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input int array");
        int[] input = Arrays.stream(bufferedReader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        long start = System.currentTimeMillis();
        int[] result = plusOne(input);
        System.out.format("Executed in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", Arrays.toString(result));
        System.out.format("Test=%s %n", Arrays.toString(new int[5]));
    }

    // Own solution, beats 100% in time (0ms)
    public static int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length+1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
            newDigits[i+1] = 0;
            if (i == 0) {
                newDigits[0]=1;
                return newDigits;
            }
        }

        return new int[]{};
    }

    // Online solution, beats 100% in time (no need to assign 0 to new int)
    public static int[] onlinePlusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

}