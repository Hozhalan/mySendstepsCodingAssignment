Feature: Checkout flow for a professional plan

  Scenario: Verify the checkout flow for the professional plan with master credit card option.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify user can select the "professional" plan and proceed to checkout with "Master" credit card details

  Scenario: Verify the checkout flow for the professional plan with visa credit card option.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify user can select the "professional" plan and proceed to checkout with "Visa" credit card details

  Scenario: Verify the checkout flow for the professional plan with american express credit card option.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify user can select the "professional" plan and proceed to checkout with "American" credit card details

  Scenario: Verify the checkout flow for the professional plan with invalid credit card details.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify user can select the "professional" plan and proceed to checkout with "invalid" credit card details

  Scenario: Verify the checkout flow for the professional plan with ideal option.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify the user can select the "professional" plan and proceed ideal option


