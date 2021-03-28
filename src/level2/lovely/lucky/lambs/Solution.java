package level2.lovely.lucky.lambs;

public class Solution {
    public static int solution(int total_lambs) {
        //Your code here

        return getMaxHenchmen(total_lambs) - getMinHenchmen(total_lambs);
    }

    private static int getMinHenchmen(int totalLambs) {

        int minHenchmen = 1;
        int remainingLambs = totalLambs;
        int prevLambs = 1;
        remainingLambs -= prevLambs;

        while (remainingLambs >= prevLambs * 2) {
            int nextLambs = prevLambs * 2;
            remainingLambs -= nextLambs;
            prevLambs = nextLambs;
            minHenchmen++;
        }

        return minHenchmen;
    }

    private static int getMaxHenchmen(int totalLambs) {

        int maxHenchmen = 1;
        int remainingLambs = totalLambs;
        int secondPrevLambs = 0;
        int prevLambs = 1;
        remainingLambs -= prevLambs;

        while (remainingLambs >= prevLambs + secondPrevLambs) {
            int nextLambs = prevLambs + secondPrevLambs;
            remainingLambs -= nextLambs;
            secondPrevLambs = prevLambs;
            prevLambs = nextLambs;
            maxHenchmen++;
        }

        return maxHenchmen;
    }
}
