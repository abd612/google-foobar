package level3.doomsday.fuel;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] solution(int[][] m) {
        // Your code here

        int[] rowSums = new int[m.length];
        int terminalStates = 0;

        List<Integer> terminalStateIndices = new ArrayList<>();
        List<Integer> nonTerminalStateIndices = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {

            int rowSum = 0;

            for (int j = 0; j < m[0].length; j++) {
                rowSum += m[i][j];
            }

            rowSums[i] = rowSum;

            if (rowSum == 0) {
                terminalStates++;
                terminalStateIndices.add(i);
            } else {
                nonTerminalStateIndices.add(i);
            }
        }

        if (rowSums[0] == 0) {
            int[] result = new int[terminalStates + 1];
            result[0] = 1;
            result[terminalStates] = 1;
            return result;
        }

        Fraction[][] fractionMatrix = new Fraction[m.length][m[0].length];

        for (int i = 0; i < fractionMatrix.length; i++) {
            for (int j = 0; j < fractionMatrix[0].length; j++) {
                fractionMatrix[i][j] = new Fraction(m[i][j], rowSums[i]);
            }
        }

        Fraction[][] transitionMatrix = new Fraction[m.length][m.length];

        for (int i = 0; i < terminalStates; i++) {
            for (int j = 0; j < transitionMatrix.length; j++) {
                if (i == j) {
                    transitionMatrix[i][j] = new Fraction(1);
                } else {
                    transitionMatrix[i][j] = new Fraction(0);
                }
            }
        }

        Fraction[][] rMatrix = new Fraction[fractionMatrix.length - terminalStates][terminalStates];
        Fraction[][] qMatrix = new Fraction[fractionMatrix.length - terminalStates][fractionMatrix.length - terminalStates];

        for (int i = terminalStates; i < fractionMatrix.length; i++) {

            for (int j = 0; j < terminalStates; j++) {
                transitionMatrix[i][j] = fractionMatrix[nonTerminalStateIndices.get(i - terminalStates)][terminalStateIndices.get(j)];
                rMatrix[i - terminalStates][j] = fractionMatrix[nonTerminalStateIndices.get(i - terminalStates)][terminalStateIndices.get(j)];
            }

            for (int j = terminalStates; j < fractionMatrix.length; j++) {
                transitionMatrix[i][j] = fractionMatrix[nonTerminalStateIndices.get(i - terminalStates)][nonTerminalStateIndices.get(j - terminalStates)];
                qMatrix[i - terminalStates][j - terminalStates] = fractionMatrix[nonTerminalStateIndices.get(i - terminalStates)][nonTerminalStateIndices.get(j - terminalStates)];
            }
        }

        Fraction[][] identityMatrix = createIdentityMatrix(qMatrix.length);
        Fraction[][] differenceMatrix = subtractMatrices(identityMatrix, qMatrix);
        Fraction[][] fMatrix = getInverseMatrix(differenceMatrix, differenceMatrix.length);
        Fraction[][] productMatrix = multiplyMatrices(fMatrix, rMatrix);

        int lcm = 1;

        for (int i = 0; i < productMatrix[0].length; i++) {
            int denominator = productMatrix[0][i].getDenominator();
            int gcd = gcd(lcm, denominator);
            lcm *= denominator / (gcd != 0 ? gcd : 1);
        }

        int[] result = new int[terminalStates + 1];

        for (int i = 0; i < productMatrix[0].length; i++) {
            int numerator = productMatrix[0][i].getNumerator() * lcm / productMatrix[0][i].getDenominator();
            result[i] = numerator;
        }

        result[result.length - 1] = lcm;

        return result;
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static Fraction[][] getCofactorMatrix(Fraction[][] originalMatrix, int p, int q, int size) {

        Fraction[][] cofactorMatrix = new Fraction[size][size];

        int i = 0;
        int j = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row != p && col != q) {
                    cofactorMatrix[i][j++] = originalMatrix[row][col];

                    if (j == size - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }

        return cofactorMatrix;
    }

    private static Fraction getDeterminant(Fraction[][] originalMatrix, int size) {

        Fraction determinant = new Fraction(0);

        if (size == 1) {
            return originalMatrix[0][0];
        }

        Fraction[][] cofactorMatrix;

        Fraction sign = new Fraction(1);

        for (int f = 0; f < size; f++) {
            cofactorMatrix = getCofactorMatrix(originalMatrix, 0, f, size);
            determinant = determinant.sum(sign.product(originalMatrix[0][f].product(getDeterminant(cofactorMatrix, size - 1))));
            sign.setNumerator(-sign.getNumerator());
        }

        return determinant;
    }

    private static Fraction[][] getAdjointMatrix(Fraction[][] originalMatrix, int size) {

        Fraction[][] adjointMatrix = new Fraction[size][size];

        if (size == 1) {
            adjointMatrix[0][0] = new Fraction(1);
            return new Fraction[][]{};
        }

        Fraction sign = new Fraction(1);
        Fraction[][] cofactorMatrix;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cofactorMatrix = getCofactorMatrix(originalMatrix, i, j, size);
                sign.setNumerator(((i + j) % 2 == 0) ? 1 : -1);
                adjointMatrix[j][i] = sign.product(getDeterminant(cofactorMatrix, size - 1));
            }
        }

        return adjointMatrix;
    }

    private static Fraction[][] getInverseMatrix(Fraction[][] originalMatrix, int size) {

        Fraction determinant = getDeterminant(originalMatrix, size);

        if (determinant.equalsTo(new Fraction(0))) {
            return new Fraction[][]{};
        }

        Fraction[][] adjointMatrix = getAdjointMatrix(originalMatrix, size);
        Fraction[][] inverseMatrix = new Fraction[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inverseMatrix[i][j] = adjointMatrix[i][j].divide(determinant);
            }
        }

        return inverseMatrix;
    }

    private static Fraction[][] createIdentityMatrix(int size) {

        Fraction[][] identityMatrix = new Fraction[size][size];

        for (int i = 0; i < identityMatrix.length; i++) {
            for (int j = 0; j < identityMatrix[0].length; j++) {
                if (i == j) {
                    identityMatrix[i][j] = new Fraction(1);
                } else {
                    identityMatrix[i][j] = new Fraction(0);
                }
            }
        }

        return identityMatrix;
    }

    private static Fraction[][] subtractMatrices(Fraction[][] firstMatrix, Fraction[][] secondMatrix) {

        Fraction[][] differenceMatrix = new Fraction[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                differenceMatrix[i][j] = firstMatrix[i][j].difference(secondMatrix[i][j]);
            }
        }

        return differenceMatrix;
    }

    private static Fraction[][] multiplyMatrices(Fraction[][] firstMatrix, Fraction[][] secondMatrix) {

        if (firstMatrix[0].length != secondMatrix.length) {
            return new Fraction[][]{};
        }

        Fraction[][] productMatrix = new Fraction[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < productMatrix.length; i++) {
            for (int j = 0; j < productMatrix[0].length; j++) {
                productMatrix[i][j] = new Fraction(0);
            }
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    productMatrix[i][j] = productMatrix[i][j].sum(firstMatrix[i][k].product(secondMatrix[k][j]));
                }
            }
        }

        return productMatrix;
    }

    public static class Fraction {

        private int numerator;
        private int denominator;

        public Fraction(int numerator) {
            this.numerator = numerator;
            this.denominator = 1;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            if (denominator != 0) {
                this.denominator = denominator;
            } else {
                this.denominator = 1;
            }

            reduce();
        }

        public void reduce() {
            int divisor = gcd(numerator, denominator);
            numerator /= divisor;
            denominator /= divisor;

            if (denominator < 0) {
                denominator = -denominator;
                numerator = -numerator;
            }
        }

        public Fraction sum(Fraction fraction) {
            int den = this.denominator * fraction.getDenominator();
            int num = this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator;
            return new Fraction(num, den);
        }

        public Fraction difference(Fraction fraction) {
            int den = this.denominator * fraction.getDenominator();
            int num = this.numerator * fraction.getDenominator() - fraction.getNumerator() * this.denominator;
            return new Fraction(num, den);
        }

        public Fraction product(Fraction fraction) {
            int den = this.denominator * fraction.getDenominator();
            int num = this.numerator * fraction.getNumerator();
            return new Fraction(num, den);
        }

        public Fraction divide(Fraction fraction) {
            int den = this.denominator * fraction.getNumerator();
            int num = this.numerator * fraction.getDenominator();
            return new Fraction(num, den);
        }

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
            reduce();
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            if (denominator != 0) {
                this.denominator = denominator;
            } else {
                this.denominator = 1;
            }

            reduce();
        }

        public boolean equalsTo(Fraction fraction) {
            if (this == fraction) return true;
            if (fraction == null || getClass() != fraction.getClass()) return false;
            return numerator == fraction.numerator && denominator == fraction.denominator;
        }

        @Override
        public String toString() {
            return String.format("%2d", numerator) + "/" + String.format("%2d", denominator);
        }
    }
}
