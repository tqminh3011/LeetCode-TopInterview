import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Examples
//
public class ClimbingStairs {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input n");
        int input = Integer.parseInt(bufferedReader.readLine());

        long start = System.currentTimeMillis();
        int result = climbStairs(input);
        System.out.format("%nExecuted in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", result);
    }

    // Own solution, beats 100% - After referencing online solution, Using Binary search
    public static int climbStairs(int n) {

        int max2Step = n / 2;
        int result = 1;

        for (int noOf2 = 1; noOf2 <= max2Step; noOf2++) {
            int noOf1 = n - (noOf2 * 2);
//            System.out.format("%n noOf1=%s, noOf2=%s", noOf1, noOf2);
            int add = (noOf1 == 0) ? 1 : combinations(Math.max(noOf1, noOf2), Math.min(noOf1, noOf2));
            result+=add;
        }

        // 8
        // 1-2s 6-1s -> 6
        // 2-2s 4-1s -> 6
        // 3-2s 2-1s -> 3
        // 4-2s -> 1
        // 8-1s -> 1

        // Critical point:
        // 1 outlier -> ways = list size
        //

        return result;
    }

    private static int combinations(int n, int r) {
        return (int) (factorial(n) / (factorial(r) * factorial(n-r)));
    }

    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = n * factorial(n-1);
        System.out.format("%nFactorial of %s=%s", n, result);

        return result;
    }

    // Online solution
    public static int onlineClimbStairs(int n) {
        return 0;
    }

}