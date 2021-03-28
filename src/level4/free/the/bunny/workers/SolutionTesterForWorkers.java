package level4.free.the.bunny.workers;

public class SolutionTesterForWorkers {

    public static void main(String[] args) {

        printMatrix(Solution.solution(2, 1));
        printMatrix(Solution.solution(5, 3));
        printMatrix(Solution.solution(4, 4));
        printMatrix(Solution.solution(4, 0));
        printMatrix(Solution.solution(4, 1));
        printMatrix(Solution.solution(1, 0));
        printMatrix(Solution.solution(1, 1));
    }

    private static void printMatrix(int[][] matrix) {

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
