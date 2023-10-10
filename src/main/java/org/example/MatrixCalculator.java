package org.example;

public class MatrixCalculator {
    public static Double traceMatrix(Double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return null;
        }
        double result = 0D;
        for (int i = 0; i < matrix.length; ++i) {
            result += matrix[i][i];
        }
        return result;
    }

    public static Double determinantMatrix(Double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return null;
        }
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        double ans = 0;
        Double B[][] = new Double[n-1][n-1];
        int l = 1;
        for(int i = 0; i < n; ++i){
            int x = 0, y = 0;
            for(int j = 1; j < n; ++j){
                for(int k = 0; k < n; ++k){
                    if(i == k) continue;
                    B[x][y] = matrix[j][k];
                    ++y;
                    if(y == n - 1){
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * matrix[0][i] * determinantMatrix(B);
            l *= (-1);
        }
        return ans;
    }

    public static Double[] cramerRule(Double[][] matrix) {
        int n = matrix.length;
        Double[] solutions = new Double[n];

        Double[][] coefficients = new Double[n][n];
        Double[] constants = new Double[n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, coefficients[i], 0, n);
            constants[i] = matrix[i][n];
        }

        Double mainDeterminant = determinantMatrix(coefficients);

        if (mainDeterminant == null || mainDeterminant == 0)
            return null;

        for (int i = 0; i < n; i++) {
            Double[][] modifiedMatrix = new Double[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(coefficients[j], 0, modifiedMatrix[j], 0, n);
            }

            for (int j = 0; j < n; j++) {
                modifiedMatrix[j][i] = constants[j];
            }

            Double determinant = determinantMatrix(modifiedMatrix);
            solutions[i] = determinant / mainDeterminant;
        }

        return solutions;
    }

    public static Double[][] addMatrices(Double[][] matrix1, Double[][] matrix2) {
        return new Double[0][];
    }
}






