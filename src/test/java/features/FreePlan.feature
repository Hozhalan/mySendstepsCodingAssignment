Feature: Checkout flow for a free plan

  Scenario: Verify the checkout flow for the free plan.
    Given the user should be on the login page
    And the user should enter the credentials and click on the 'LoginNow' button
    And the user should click on the 'UpdateMyAccount' button
    Then verify user can select the "free" plan and proceed to checkout with "Master" credit card details



