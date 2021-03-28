package level5.disorderly.escape;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static String solution(int w, int h, int s) {
        // Your code here

        List<BigInteger> numerators = new ArrayList<>();
        List<BigInteger> denominators = new ArrayList<>();
        List<List<Integer>> wPartitions = new ArrayList<>();
        List<List<Integer>> hPartitions = new ArrayList<>();

        getPartitions(w, w, 0, new int[w], wPartitions);
        getPartitions(h, h, 0, new int[h], hPartitions);

        for (List<Integer> wPartition : wPartitions) {
            for (List<Integer> hPartition : hPartitions) {

                List<Integer> wPartitionUnique = new ArrayList<>(new HashSet<>(wPartition));
                List<Integer> hPartitionUnique = new ArrayList<>(new HashSet<>(hPartition));

                BigInteger denominator = BigInteger.ONE;

                for (int element : wPartitionUnique) {
                    int frequency = Collections.frequency(wPartition, element);
                    denominator = denominator.multiply(BigInteger.valueOf((int) (Math.pow(element, frequency) * factorial(frequency))));
                }

                for (int element : hPartitionUnique) {
                    int frequency = Collections.frequency(hPartition, element);
                    denominator = denominator.multiply(BigInteger.valueOf((int) (Math.pow(element, frequency) * factorial(frequency))));
                }

                BigInteger exponent = BigInteger.ZERO;

                for (Integer wElement : wPartition) {
                    for (Integer hElement : hPartition) {
                        exponent = exponent.add(BigInteger.valueOf(gcd(wElement, hElement)));
                    }
                }

                BigInteger numerator = BigInteger.valueOf(s).pow(exponent.intValue());

                numerators.add(numerator);
                denominators.add(denominator);
            }
        }

        BigInteger totalDenominator = BigInteger.ONE;

        for (int i = 0; i < denominators.size(); i++) {
            totalDenominator = totalDenominator.multiply(denominators.get(i));
        }

        BigInteger totalNumerator = BigInteger.ZERO;

        for (int i = 0; i < numerators.size(); i++) {
            totalNumerator = totalNumerator.add(numerators.get(i).multiply(totalDenominator.divide(denominators.get(i))));
        }

        BigInteger nonEqConfigs = totalNumerator.divide(totalDenominator);

        return nonEqConfigs.toString();
    }

    private static int factorial(int n) {

        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static void getPartitions(int remainingValue, int maximumValue, int index, int[] currentPartitionArray, List<List<Integer>> partitionsList) {

        if (remainingValue == 0) {
            List<Integer> currentPartitionList = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                currentPartitionList.add(currentPartitionArray[i]);
            }
            partitionsList.add(currentPartitionList);
            return;
        }

        for (int i = maximumValue; i > 0; i--) {
            if (i <= remainingValue) {
                currentPartitionArray[index] = i;
                getPartitions(remainingValue - i, i, index + 1, currentPartitionArray, partitionsList);
            }
        }
    }
}
