Feature: EndToEnd

  Scenario: Successfully order the product
    Given user open the browser
    And open the url "http://localhost:8081/opencart/upload/"
    When user navigate to Homepage
    And click on register
    And user enter firstname
    And user enter lastname
    And user enter email
    And user enter telephone
    And user enter password
    And user enter confirm password
    And user click the subscribe buttn yes
    And user click the privacy policy
    And user click the continue button
    Then validate the success message
    And click on continue
    And validate the My Account page
    And logout from application
    # login with newly created account
    When user navigate to Homepage
    And click on Login
    And User enters Email and Password
    Then click the Login button
    # search product & select the product
    When type the prduct name as "mac"
    And click on search  button
    Then verify the searched product and click the searched product
    # Select the product quantity and add the product to cart
    When select the cart value
    And click on add to cart
    Then verify the confirmation message after add the product to cart
    And click on view to verify product added to cart
    # verify the product in shopping cart page
    When click on estimate tax and fill the details
    Then verify the price of the product after fill the details
    And click on checkout button
    # Checkout the product providing all the details
    When user enter the details of address & continue to place the order
    Then verify order is Successfully placed
    And click on continue to homepage
