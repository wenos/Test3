package org.example;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        MatrixCalculator mathCalculator = new MatrixCalculator();
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
                    outputMatrix(inputMatrix());
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    break;
                }
                case 0: {
                    flag = false;
                    break;
                }
            }
        }
    }
    public static double[][] inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы");
        int n = scanner.nextInt(), m = scanner.nextInt();
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
    public static void outputMatrix(double[][] matrix) {
        for (double[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

}
