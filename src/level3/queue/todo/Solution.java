package level3.queue.todo;

public class Solution {
    public static int solution(int start, int length) {
        //Your code goes here.

        int result = 0;

        for (int i = 0; i < length; i++) {
            for (int j = start; j < start + length - i; j++) {
                result ^= j + i * length;
            }
        }

        return result;
    }
}
