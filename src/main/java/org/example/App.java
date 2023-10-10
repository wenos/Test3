package org.example;


import java.util.Objects;
import java.util.Arrays;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите действие, которое хотите сделать");
            System.out.println("1 - Сложить две матрицы");
            System.out.println("2 - Вычесть из одной матрицы другую матрицы");
            System.out.println("3 - Найти след матрицы");
            System.out.println("4 - Найти детерминант матрицы");
            System.out.println("5 - Найти ранг матрицы");
            System.out.println("6 - Транспонировать матрицу");
            System.out.println("7 - Умножение двух матриц");
            System.out.println("8 - Решить систему линейных уравнений");
            System.out.println("0 - Завершить работу программы");
            int activate = scanner.nextInt();
            switch (activate) {
                case 1: {
                    System.out.println("Ввод первой матрицы:");
                    Double[][] matrix1 = inputMatrix();
                    System.out.println("Ввод второй матрицы:");
                    Double[][] matrix2 = inputMatrix();
                    System.out.println("Получившаяся матрица:");
                    outputMatrix(MatrixCalculator.addMatrices(matrix1, matrix2));
                    break;
                }
                case 2: {
                    System.out.println("Ввод первой матрицы:");
                    Double[][] matrix1 = inputMatrix();
                    System.out.println("Ввод второй матрицы:");
                    Double[][] matrix2 = inputMatrix();
                    System.out.println("Получившаяся матрица:");
                    outputMatrix(MatrixCalculator.matrixSubtraction(matrix1, matrix2));
                    break;
                }
                case 3: {
                    System.out.println("След равен: " + MatrixCalculator.traceMatrix(inputMatrix()));
                    break;
                }
                case 4: {
                    System.out.println("Определитель равен: " + MatrixCalculator.determinantMatrix(inputMatrix()));
                    break;
                }
                case 5: {
                    System.out.println("Ранг равен: " + MatrixCalculator.findMatrixRank(inputMatrix()));
                    break;
                }
                case 6: {
                    System.out.println("Ввод матрицы:");
                    Double[][] matrix = inputMatrix();
                    System.out.println("Транспонированная матрица:");
                    outputMatrix(MatrixCalculator.transpose(matrix));
                    break;
                }
                case 7: {
                    System.out.println("Ввод первой матрицы:");
                    Double[][] matrix1 = inputMatrix();
                    System.out.println("Ввод второй матрицы:");
                    Double[][] matrix2 = inputMatrix();
                    System.out.println("Получившаяся матрица:");
                    outputMatrix(Objects.requireNonNull(MatrixCalculator.multiply(matrix1, matrix2)));
                    break;
                }
                case 8: {
                    System.out.println("Решение системы: " + Arrays.toString(MatrixCalculator.cramerRule(inputMatrix())));
                    break;
                }
                case 0: {
                    flag = false;
                    break;
                }
            }
        }
    }
    public static Double[][] inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы");
        int n = scanner.nextInt(), m = scanner.nextInt();
        Double[][] matrix = new Double[n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
    public static void outputMatrix(Double[][] matrix) {
        if(matrix == null) {
            System.out.println("null");
            return;
        }
        for (Double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
    }

}
