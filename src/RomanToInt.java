import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RomanToInt {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        long start = System.currentTimeMillis();
        int result = bestRomanToInt(input);
        System.out.format("Executed in %sms\n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s \n", result);
    }

    // Own solution, beats 16% in time
    public static int romanToInt(String s) {

        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i=0;
        while(i < s.length()) {
            if (i < s.length() - 1) {
                Integer subtraction = map.get(s.substring(i, i+2));
                if (subtraction != null) {
                    result+=subtraction;
                    i+=2;
                    continue;
                }
            }

            int intValue = map.get(String.valueOf(s.charAt(i)));
            result+=intValue;
            i++;
        }


        return result;
    }

    // Online solution, beats 90% in time
    public static int bestRomanToInt(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}