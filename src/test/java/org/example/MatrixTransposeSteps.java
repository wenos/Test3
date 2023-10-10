package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MatrixTransposeSteps {
    private Double[][] matrix;
    private Double[][] result;

    @Given("У меня есть транспонируемая матрица {int}x{int}")
    public void createMatrix(int rows, int cols) {
        matrix = new Double[rows][cols];
    }

    @Given("Я заполняю ее следующими элементами:")
    public void fillMatrixWithElements(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = Double.parseDouble(row.get(j));
            }
        }
    }

    @When("Я использую метод транспонирования матрицы")
    public void transposeMatrix() {
        result = MatrixCalculator.transpose(matrix);
    }

    @Then("В результате выполнения функции должен получить:")
    public void resultOnScreen(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        int rows = table.size();
        int cols = table.get(0).size();
        Double[][] expectedMatrix = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < cols; j++) {
                expectedMatrix[i][j] = Double.parseDouble(row.get(j));
            }
        }
        Assert.assertArrayEquals(expectedMatrix, result);
    }
}


