package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static java.lang.Double.valueOf;
import static org.junit.Assert.assertEquals;

public class RankSteps {
    private Double[][] matrix;
    private Double rank;

    @Given("У меня есть матрица {int}x{int}")
        public void iHaveAMatrix(int rows, int cols) {
        matrix = new Double[rows][cols];
    }

    @And("Я заполняю ее элементами:")
    public void iHaveEnteredTheElements(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = Double.parseDouble(row.get(j));
            }
        }
    }

    @When("Я использую метод вычисления ранга матрицы")
    public void iCalculateTheRank() {
        rank = MatrixCalculator.findMatrixRank(matrix);
    }

    @Then("В результате я должна получить {double}")
    public void verifyMatrixRank(Double expectedRank) {
        assertEquals(expectedRank, rank);
    }
}