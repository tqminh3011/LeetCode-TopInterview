import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

// Examples
// 0,0,1,1,1,2,2,3,3,4
public class RemoveDupSortedArray {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] input  = Arrays.stream(bufferedReader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        long start = System.currentTimeMillis();
        int result = removeDuplicates(input);
        System.out.format("Executed in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", result);
        System.out.format("nums=%s %n", Arrays.toString(input));
    }

    // Own solution, beats 100% in time (1ms)
    public static int removeDuplicates(int[] nums) {
        // No Set (1ms)
        int counter=0;
        int previous = Integer.MIN_VALUE;
        for (int i=0; i<nums.length;i++) {
            int num = nums[i];
            if (nums[i] != previous) {
                nums[counter] = num;
                previous = num;
                counter++;
            }
        }

        return counter;

        // Using Set (2ms)
//        Set<Integer> set = new HashSet<>();
//
//        int counter=0;
//        for (int i=0; i<nums.length;i++) {
//            int num = nums[i];
//            if (!set.contains(num)) {
//                nums[counter] = num;
//                set.add(num);
//                counter++;
//            }
//        }
//
//        return set.size();
    }

    // Online solution, beats 73% in time
    public static int onlineRemoveDuplicates(int[] nums) {
        return 0;
    }

}