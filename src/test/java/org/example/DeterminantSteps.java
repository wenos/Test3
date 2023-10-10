package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class DeterminantSteps {
    private double[][] matrix;
    private Double determinant;

    @Given("I have a {int}x{int} matrix")
    public void iHaveAMatrix(int rows, int cols) {
        matrix = new double[rows][cols];
    }

    @Given("I have entered the elements:")
    public void iHaveEnteredTheElements(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = Integer.parseInt(row.get(j));
            }
        }
    }

    @When("I calculate the determinant")
    public void iCalculateTheDeterminant() {
        determinant = MatrixCalculator.calculateDeterminant(matrix);
    }

    @Then("the result should be {Double} on the screen")
    public void theResultShouldBeOnTheScreen(Double expectedDeterminant) {
        Assert.assertEquals(expectedDeterminant, determinant);
    }
}