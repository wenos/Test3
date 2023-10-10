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

    public static Double[][] matrixSubtraction (Double[][] matrix1, Double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        if (rows != matrix2.length || cols != matrix2[0].length) {
            return null;
        }

        Double[][] result = new Double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }
    

}
