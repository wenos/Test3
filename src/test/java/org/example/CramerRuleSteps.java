package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CramerRuleSteps {
    private Double[] answer;
    private Double[][] matrix;

    @Given("Есть матрица {int}x{int}")
    public void iHaveAMatrix(int rows, int cols) {
        matrix = new Double[rows][cols];
    }

    @And("Она заполнена элементами:")
    public void matrixFilledWithElements(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> table = dataTable.asLists();
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            for (int j = 0; j < row.size(); j++) {
                matrix[i][j] = Double.parseDouble(row.get(j));
            }
        }
    }

    @When("Я решаю СЛАУ методом Крамера")
    public void iUseCramerRule() {
        answer = MatrixCalculator.cramerRule(matrix);
    }

    @Then("В результате должен получить:")
    public void cramerResultAssertEquals(io.cucumber.datatable.DataTable dataTable) {
        Double[] expectedAnswer = dataTable.asList(Double.class).toArray(Double[]::new);
        Assert.assertArrayEquals(expectedAnswer, answer);
    }
}
