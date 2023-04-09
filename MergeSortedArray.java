import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// Examples
// 0, 1, 3, 5, 8, 0, 0, 0, 0
// 2, 4, 9, 10
// 0, 1, 2, 3, 4, 5, 8, 9, 10
public class MergeSortedArray {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.println("Input list1");
        String inputList1 = scanner.nextLine().trim();
        int[] list1 = inputList1.equals("") ? new int[]{} :
                Arrays.stream(inputList1.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        System.out.println("Input m");
        int m = Integer.parseInt(scanner.nextLine());

        System.out.println("Input list2");

        String inputList2 = scanner.nextLine().trim();
        int[] list2 = inputList2.equals("") ? new int[]{} :
                Arrays.stream(inputList2.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Input n");
        int n = scanner.nextInt();

        long start = System.currentTimeMillis();
        merge(list1, m, list2, n);
        System.out.format("Executed in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", Arrays.toString(list1));
    }

    // Own solution, beats 100% in time (0ms)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int[] copyNums1 = Arrays.copyOf(nums1, nums1.length);
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < copyNums1.length; i++) {

            int nums1Value = (counter1>=m) ? Integer.MAX_VALUE : copyNums1[counter1];

            if (counter2 < n && nums1Value > nums2[counter2]) {
                nums1[i] = nums2[counter2];
                counter2++;
            } else if (counter1 < m) {
                nums1[i] = copyNums1[counter1];
                counter1++;
            }
        }
    }

    // Online solution, 2 counters from m and n position
    public static void onlineMerge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while(j>=0)
            A[k--] = B[j--];
    }


}