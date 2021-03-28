package level4.running.with.bunnies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static List<Integer> resultList = new ArrayList<>();
    static Integer currentSize = 0;

    public static int[] solution(int[][] times, int times_limit) {
        // Your code here

        int size = times.length;

        if (size <= 2) {
            return new int[]{};
        }

        if (checkNegativeCycle(times)) {
            int[] result = new int[size - 2];

            for (int i = 0; i < size - 2; i++) {
                result[i] = i;
            }

            return result;
        }

        boolean[] traversed = new boolean[size];
        traversed[0] = true;
        resultList = new ArrayList<>();
        currentSize = 0;

        for (int i = 1; i < size - 1; i++) {
            depthFirstSearch(i, new ArrayList<>(), traversed, times, times_limit - times[0][i]);
        }

        if (resultList.isEmpty()) {
            return new int[]{};
        }

        Collections.sort(resultList);
        int[] resultArray = new int[resultList.size()];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    private static boolean checkNegativeCycle(int[][] times) {

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length; j++) {
                for (int k = 0; k < times.length; k++) {
                    if (times[i][j] > times[i][k] + times[k][j]) {
                        times[i][j] = times[i][k] + times[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < times.length; i++) {
            if (times[i][i] < 0) {
                return true;
            }
        }

        return false;
    }

    private static void depthFirstSearch(int i, List<Integer> currentList, boolean[] traversed, int[][] times, int remainingTime) {

        int size = times.length;

        if ((remainingTime < 0 && i == size - 1) || currentSize == size - 2 || traversed[i]) {
            return;
        }

        if (remainingTime >= 0 && i == size - 1) {
            if (currentList.size() > currentSize) {
                resultList = new ArrayList<>(currentList);
                currentSize = currentList.size();
            }
            return;
        }

        currentList.add(i - 1);
        traversed[i] = true;

        for (int j = 0; j < size; j++) {
            if (i != j) {
                depthFirstSearch(j, currentList, traversed, times, remainingTime - times[i][j]);
            }
        }

        currentList.remove(currentList.size() - 1);
        traversed[i] = false;
    }
}
