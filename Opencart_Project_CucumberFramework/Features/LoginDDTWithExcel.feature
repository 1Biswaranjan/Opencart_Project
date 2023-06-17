Feature: Login 

  Scenario Outline: Login Data Driven Excel
    Given user open the browser
    And open the url "http://localhost:8081/opencart/upload/"
    When user navigate to Homepage
    And click on Login
    Then check User navigates to MyAccount Page by passing Email and Password with excel row "<row_index>"

    Examples:
      |row_index|
      |1|
      |2|
      |3|
      |4|