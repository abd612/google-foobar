package level4.free.the.bunny.workers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[][] solution(int num_buns, int num_required) {
        // Your code here

        int r = num_buns - num_required + 1;
        List<int[]> combinations = getCombinations(num_buns, r);
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < num_buns; i++) {
            resultList.add(new ArrayList<>());
        }

        for (int i = 0; i < combinations.size(); i++) {
            int[] combination = combinations.get(i);

            for (int j = 0; j < combination.length; j++) {
                resultList.get(combination[j]).add(i);
            }
        }

        int[][] resultArray = new int[resultList.size()][resultList.get(0).size()];

        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                resultArray[i][j] = resultList.get(i).get(j);
            }
        }

        return resultArray;
    }

    private static List<int[]> getCombinations(int n, int r) {

        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];
        generateCombinations(combinations, combination, 0, n - 1, 0);
        return combinations;
    }

    private static void generateCombinations(List<int[]> combinations, int[] combination, int start, int end, int index) {

        if (index == combination.length) {
            combinations.add(combination.clone());
        } else if (start <= end) {
            combination[index] = start;
            generateCombinations(combinations, combination, start + 1, end, index + 1);
            generateCombinations(combinations, combination, start + 1, end, index);
        }
    }
}
