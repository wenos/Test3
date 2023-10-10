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


    public static Double[][] multiply(Double[][] matrix1, Double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) return null;

        Double[][] result = new Double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0.0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
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
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
            return null;

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        Double[][] result = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }



    public static Double[][] transpose(Double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Double[][] result = new Double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];

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

    public static Double findMatrixRank(Double[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        Double rank = 0.0;

        for (int row = 0; row < rowCount; row++) {
            boolean allZeroes = true;

            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] != 0.0) {
                    allZeroes = false;
                    break;
                }
            }

            if (!allZeroes) {
                rank++;

                for (int i = row + 1; i < rowCount; i++) {
                    double factor = matrix[i][row] / matrix[row][row];
                    for (int j = row; j < colCount; j++) {
                        matrix[i][j] -= factor * matrix[row][j];
                    }
                }
            }
        }

        return rank;
    }



}







