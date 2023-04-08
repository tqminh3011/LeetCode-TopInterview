import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Examples
//
public class Sqrt {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input int");
        int input = Integer.parseInt(bufferedReader.readLine());

        long start = System.currentTimeMillis();
        int result = mySqrt(input);
        System.out.format("%nExecuted in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", result);
    }

    // Own solution, beats 100% - After referencing online solution, Using Binary search
    public static int mySqrt(int x) {

        // Own solution, 2ms, beats 27% in time
//        if (x == 0 || x==1) {
//            return x;
//        }
//
//        int lowerBound = 0;
//        int upperBound = x;
//        int testing = x/2;
//
//        while (true) {
//            if (testing > x / testing) {
//                upperBound = testing;
//                testing = testing/2;
//            } else if (testing < x / testing) {
//                lowerBound = testing;
//                testing = (upperBound + lowerBound) / 2;
//            } else {
//                return testing;
//            }
//
//            if (testing == lowerBound || testing == upperBound) {
//                return testing;
//            }
//        }


        // 5 -> l=1, h=5
        // mid= 3 -> 9>5 -> l=1,h=2
        // mid= 1 -> 1<5 && 4<5-> l=2,h=2
        // mid= 2 -> 4<5 && 9>5 -> RESULT = 2

        // 3 -> l=1, h=3
        // mid= 2 -> 4>3 -> l=1,h=1
        // mid= 1 -> 1<3 && 4>2-> RESULT = 1

        // 9 -> l=1, h=9
        // mid= 5 -> 25>9 -> l=1,h=4
        // mid= 2 -> 4<9 && 9==9 -> l=1

        if (x==0) return 0;

        //  Look for the critical point: i * i <= x && (i+1)(i+1) > x
        int low = 1, high = x, mid=0;
        while (true) {
            System.out.format("%n Lower=%s, Upper=%s, Mid=%s", low, high, mid);
            mid = (low + high) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else if ((mid + 1) < x/ (mid + 1)) {
                low = mid + 1;
            } else if ((mid + 1) > x / (mid + 1)) {
                return mid;
            } else {
                return mid + 1;
            }
        }

    }

    // Online solution, beats 100% in time - using BINARY SEARCH
    public static int onlineMySqrt(int x) {

        // 10000 (l=1,r=10000)
        // mid= 1 + 9999/2 = 5000

        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            System.out.format("%n Lower=%s, Upper=%s, Mid=%s", left, right, mid);
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

}