package level5.expanding.nebula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int solution(boolean[][] g) {
        // Your code here

        int rowCount = g.length;
        int colCount = g[0].length;

        if (colCount > rowCount) {
            g = getTransposeMatrix(g);
            rowCount = g.length;
            colCount = g[0].length;
        }

        List<Integer> rowReps = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            rowReps.add(0);

            for (int j = 0; j < colCount; j++) {
                rowReps.set(i, rowReps.get(i) + (g[i][j] ? 1 << j : 0));
            }
        }

        Map<Integer, Map<Integer, List<Integer>>> completeMappings = new HashMap<>();
        int prevStateGridCount = 1 << (colCount + 1);

        for (int i = 0; i < prevStateGridCount; i++) {
            for (int j = 0; j < prevStateGridCount; j++) {
                int nextRowRep = generateNextRowRep(i, j, colCount);

                if(rowReps.contains(nextRowRep)) {
                    if (completeMappings.containsKey(nextRowRep) && completeMappings.get(nextRowRep).containsKey(i)) {
                        completeMappings.get(nextRowRep).get(i).add(j);
                    } else if (completeMappings.containsKey(nextRowRep)) {
                        completeMappings.get(nextRowRep).put(i, new ArrayList<>(Collections.singletonList(j)));
                    } else {
                        completeMappings.put(nextRowRep, new HashMap<>());
                        completeMappings.get(nextRowRep).put(i, new ArrayList<>(Collections.singletonList(j)));
                    }
                }
            }
        }

        Map<Integer, Integer> prevStates = new HashMap<>();

        for (int i = 0; i < prevStateGridCount; i++) {
            prevStates.put(i, 1);
        }

        for (Integer rowRep : rowReps) {
            Map<Integer, Integer> nextRow = new HashMap<>();

            for (Map.Entry<Integer, Integer> preImageEntry : prevStates.entrySet()) {
                List<Integer> currentMapping = completeMappings.get(rowRep).get(preImageEntry.getKey());

                if (currentMapping == null) {
                    continue;
                }

                for (Integer element : currentMapping) {
                    if (nextRow.containsKey(element)) {
                        nextRow.put(element, nextRow.get(element) + preImageEntry.getValue());
                    } else {
                        nextRow.put(element, preImageEntry.getValue());
                    }
                }
            }

            prevStates = nextRow;
        }

        return prevStates.values().stream().mapToInt(Integer::valueOf).sum();
    }

    private static int generateNextRowRep(int i, int j, int size) {

        int a = i & ~(1 << size);
        int b = j & ~(1 << size);
        int c = i >> 1;
        int d = j >> 1;

        return (a & ~b & ~c & ~d) | (~a & b & ~c & ~d) | (~a & ~b & c & ~d) | (~a & ~b & ~c & d);
    }

    private static boolean[][] getTransposeMatrix(boolean[][] originalMatrix) {

        boolean[][] transposeMatrix = new boolean[originalMatrix[0].length][originalMatrix.length];

        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[0].length; j++) {
                transposeMatrix[j][i] = originalMatrix[i][j];
            }
        }

        return transposeMatrix;
    }
}
