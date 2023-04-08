import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Examples
// flower,flow,flight
// dog,racecar,car
// abc,a
public class LongestCommonPrefix {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = bufferedReader.readLine().split(",");

        long start = System.currentTimeMillis();
        String result = longestCommonPrefix(input);
        System.out.format("Executed in %sms\n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s \n", result);
    }

    // Own solution, beats 75% in time
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        String first = strs[0];
        for (int j=0; j < first.length(); j++) {
            char c = first.charAt(j);
            boolean matching = true;
            for (String str : strs) {
                if (str.length() <= j || c != str.charAt(j)) {
                    matching = false;
                    break;
                }
            }

            if (!matching) {
                break;
            }

            result.append(c);
        }

        return result.toString();
    }

    // Online solution, beats 75% in time
    public String onlineLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length())
        {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}