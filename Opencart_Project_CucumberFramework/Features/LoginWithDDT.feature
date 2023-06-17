Feature: Login

  Scenario Outline: Login With Data Driven
    Given user open the browser
    And open the url "http://localhost:8081/opencart/upload/"
    When user navigate to Homepage
    And click on Login
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then validate the My Account page

    Examples: 
      | email                | password |
      | abc@gmail.com        | abc@1234  |
      | test1_user@gmail.com | Test@123 |
