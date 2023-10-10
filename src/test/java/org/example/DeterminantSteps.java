package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DeterminantSteps {
    private Double[][] matrix;
    private Double determinant;

    @Given("У меня есть матрица {int}x{int}")
    public void iHaveAMatrix(int rows, int cols) {
        matrix = new Double[rows][cols];
    }

    @Given("Я заполняю ее элементами:")
    public void iHaveEnteredTheElements(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = Double.parseDouble(row.get(j));
            }
        }
    }

    @When("Я использую метод подсчета детерминанта")
    public void iCalculateTheDeterminant() {
        determinant = MatrixCalculator.determinantMatrix(matrix);
    }

    @Then("В результате должен получить {double}")
    public void theResultShouldBeOnTheScreen(Double expectedDeterminant) {
        Assert.assertEquals(expectedDeterminant, determinant);
    }



}