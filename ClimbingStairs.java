import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


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

        // 8
        // 1-2s 6-1s -> 6
        // 2-2s 4-1s -> 15
        // 3-2s 2-1s -> 10
        // 4-2s -> 1
        // 8-1s -> 1

        // CRITICAL POINT: Should utilize combination equation (nCr) with BigInteger used to prevent ArithmeticException


        int max2Step = n / 2;
        int result = 1;

        for (int noOf2 = 1; noOf2 <= max2Step; noOf2++) {
            int noOf1 = n - (noOf2 * 2);
            int add = (noOf1 == 0) ? 1 : combinations(noOf1 + noOf2, Math.min(noOf1, noOf2));
            result+=add;
        }


        return result;
    }

    private static int combinations(int n, int r) {

        BigInteger result = BigInteger.ONE;
        for (int i= n-r+1; i <= n; i++) {
            result= result.multiply(BigInteger.valueOf(i));
        }

        result = result.divide(BigInteger.valueOf(factorial(r)));
//        System.out.format("%nCombinations of n=%s and r=%s = %s", n,r,result);

        return result.intValue();

        // Can't use normal factorial func due to too large result - out of number type max value
        //        return (factorial(n) / (factorial(r) * factorial(n-r)));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = n * factorial(n-1);
//        System.out.format("%nFactorial of %s=%s", n, result);

        return result;
    }

    // Online solution - Thinking it like Fibonacci numbers (hint: Dynamic Programming)
    public static int onlineClimbStairs(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

}