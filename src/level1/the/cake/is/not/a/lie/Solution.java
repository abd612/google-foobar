package level1.the.cake.is.not.a.lie;

public class Solution {
    public static int solution(String x) {
        //Your code here

        char firstChar = x.charAt(0);
        int nextIndex = 0;
        int count;
        boolean noLeftovers;

        do {
            nextIndex = x.indexOf(firstChar, nextIndex + 1);

            if (nextIndex == -1) {
                nextIndex = x.length();
            }

            String substring = x.substring(0, nextIndex);
            count = 0;
            int index = 0;

            while (index != -1) {
                count++;
                index += substring.length();
                index = x.indexOf(substring, index);
            }

            noLeftovers = substring.length() * count == x.length();

        } while (!noLeftovers);

        return count;
    }
}
