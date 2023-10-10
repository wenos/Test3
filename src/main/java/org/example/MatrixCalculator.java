package org.example;


public class MatrixCalculator {
    public static Double traceMatrix(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return null;
        }
        double result = 0D;
        for (int i = 0; i < matrix.length; ++i) {
            result += matrix[i][i];
        }
        return result;
    }
}
