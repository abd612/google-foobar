package level3.doomsday.fuel;

import java.util.ArrayList;
import java.util.List;

public class SolutionTesterForFuel {

    public static void main(String[] args) {

        List<String> expectedOutputs = new ArrayList<>();
        List<String> actualOutputs = new ArrayList<>();

        List<int[][]> inputs = new ArrayList<>();

        inputs.add(new int[][]{{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{1, 2, 3, 0, 0, 0}, {4, 5, 6, 0, 0, 0}, {7, 8, 9, 1, 0, 0}, {0, 0, 0, 0, 1, 2}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0}});
        inputs.add(new int[][]{{0, 0, 12, 0, 15, 0, 0, 0, 1, 8}, {0, 0, 60, 0, 0, 7, 13, 0, 0, 0}, {0, 15, 0, 8, 7, 0, 0, 1, 9, 0}, {23, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {37, 35, 0, 0, 0, 0, 3, 21, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0, 7, 0, 17, 0, 1, 0, 5, 0, 2}, {0, 0, 29, 0, 28, 0, 3, 0, 16, 0}, {0, 3, 0, 0, 0, 1, 0, 0, 0, 0}, {48, 0, 3, 0, 0, 0, 17, 0, 0, 0}, {0, 6, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{1, 1, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 0, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0, 86, 61, 189, 0, 18, 12, 33, 66, 39}, {0, 0, 2, 0, 0, 1, 0, 0, 0, 0}, {15, 187, 0, 0, 18, 23, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0, 0, 0, 0, 3, 5, 0, 0, 0, 2}, {0, 0, 4, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 4, 4, 0, 0, 0, 1, 1}, {13, 0, 0, 0, 0, 0, 2, 0, 0, 0}, {0, 1, 8, 7, 0, 0, 0, 1, 3, 0}, {1, 7, 0, 0, 0, 0, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
        inputs.add(new int[][]{{0, 0, 0, 0, 0, 0}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}});

        expectedOutputs.add("[7, 6, 8, 21]");
        expectedOutputs.add("[0, 3, 2, 9, 14]");
        expectedOutputs.add("[1, 2, 3]");
        expectedOutputs.add("[1, 1]");
        expectedOutputs.add("[1, 2, 3, 4, 5, 15]");
        expectedOutputs.add("[4, 5, 5, 4, 2, 20]");
        expectedOutputs.add("[1, 1, 1, 1, 1, 5]");
        expectedOutputs.add("[2, 1, 1, 1, 1, 6]");
        expectedOutputs.add("[6, 44, 4, 11, 22, 13, 100]");
        expectedOutputs.add("[1, 1, 1, 2, 5]");
        expectedOutputs.add("[1, 0, 0, 0, 0, 1]");

        for (int[][] input : inputs) {
            actualOutputs.add(arrayToString(Solution.solution(input)));
        }

        for (int i = 0; i < expectedOutputs.size(); i++) {
            System.out.print("Test " + (i + 1) + " - ");
            if (expectedOutputs.get(i).equals(actualOutputs.get(i))) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
            }

            System.out.println("Expected: " + expectedOutputs.get(i));
            System.out.println("  Actual: " + actualOutputs.get(i));
            System.out.println("");
        }
    }

    private static String arrayToString(int[] array) {

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    private static void printFractionedMatrix(Solution.Fraction[][] matrix) {

        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[0].length - 1) {
                    System.out.print(", ");
                }
            }
            if (i < matrix.length - 1) {
                System.out.println("],");
            } else {
                System.out.println("]");
            }
        }
        System.out.println("]");
    }
}
