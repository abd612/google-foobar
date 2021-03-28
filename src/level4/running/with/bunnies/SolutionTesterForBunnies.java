package level4.running.with.bunnies;

import java.util.Arrays;

public class SolutionTesterForBunnies {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(Solution.solution(new int[][]{{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}}, 3)));
        System.out.println(Arrays.toString(Solution.solution(new int[][]{{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}}, 1)));
    }
}
