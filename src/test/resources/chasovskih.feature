Feature: Расчет ранга матрицы
  Scenario: Вычислить ранг матрицы
    Given У меня есть матрица 3x3
    And Я заполняю ее элементами:
      | 2 | 3 | 20 |
      | 4 | 5 | 100 |
      | 12 | -12| 0 |
    When Я использую метод вычисления ранга матрицы
    Then В результате я должна получить 3.0