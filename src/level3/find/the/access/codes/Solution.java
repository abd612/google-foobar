package level3.find.the.access.codes;

public class Solution {
    public static int solution(int[] l) {
        // Your code here

        int luckyTriples = 0;

        for (int i = 0; i < l.length; i++) {
            for (int j = i + 1; j < l.length; j++) {
                for (int k = j + 1; k < l.length; k++) {
                    if (l[j] % l[i] == 0 && l[k] % l[j] == 0) {
                        luckyTriples++;
                    }
                }
            }
        }

        return luckyTriples;
    }
}
