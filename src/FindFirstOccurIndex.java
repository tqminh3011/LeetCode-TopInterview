import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Examples
// haystack = "sadbutsad", needle = "sad" -> 0
// haystack = "leetcode", needle = "leeto" -> -1
public class FindFirstOccurIndex {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input haystack");
        String haystack = bufferedReader.readLine();
        System.out.println("Input needle");
        String needle = bufferedReader.readLine();

        long start = System.currentTimeMillis();
        int result = strStr(haystack, needle);
        System.out.format("Executed in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", result);
    }

    // Own solution, beats 100% in time (0ms)
    public static int strStr(String haystack, String needle) {
        char[] hayChars = haystack.toCharArray();
        char[] neeChars = needle.toCharArray();

        for (int i = 0; i < hayChars.length; i++) {
            char c = hayChars[i];

            if (i + neeChars.length > hayChars.length) {
                break;
            }

            if (c == neeChars[0]) {
                String sub = haystack.substring(i, i + neeChars.length);
                if (sub.equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    // Online solution, beats 100% in time (optimized using KMP)
    public static int onlineStrStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int[] parr = kmpPreprocess(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = parr[j - 1];
            } else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private static int[] kmpPreprocess(String pattern) {
        int i = 1, j = 0;
        int[] res = new int[pattern.length()];
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {
                j = res[j-1];
            } else {
                res[i] = 0;
                i++;
            }
        }
        return res;
    }

}