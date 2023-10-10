Feature: Расчет определителя матрицы
  Scenario: Расчет определителя матрицы 2x2
    Given I have a 2x2 matrix
    And I have entered the elements:
      | 2 | 3 |
      | 4 | 5 |
    When I calculate the determinant
    Then the result should be 2.0 on the screen