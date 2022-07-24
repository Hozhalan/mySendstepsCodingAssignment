package steps;

import base.BaseTests;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.IDealIssuerSimulationPage;
import pages.SelectYourBankPage;

public class CheckoutWithIDealStepDefinition extends BaseTests {

  @Then("verify the user can select the {string} plan and proceed ideal option")
  public void the_user_should_select_the_bank_type_and_proceed_with_payment(String planType) {
    WebElement availabilityStatus = checkWhetherThePlanIsAvailable(planType);
    if (availabilityStatus.getAttribute("class").contains("disabled")) {
      Assert.assertEquals("Not available", availabilityStatus.getText());

    } else {
      checkoutPage = chooseYourPlanPage.selectThePlan(planType);
      checkoutPage.clickOnIDealTab();
      selectYourBankPage = (SelectYourBankPage) checkoutPage.clickUpgradeNowButton();
      selectYourBankPage.selectYourBank();
      IDealIssuerSimulationPage iDealIssuerSimulationPage = selectYourBankPage.clickProceedButton();
      userHome = iDealIssuerSimulationPage.clickContinueButton();
      String dialogContentText = userHome.getDialogContentText();
      Assert.assertEquals("Thank you for your purchase!", dialogContentText);
    }
  }

  public WebElement checkWhetherThePlanIsAvailable(String planType) {
    WebElement planIsAvailableStatus = null;

    if (planType.equals("free")) {
      planIsAvailableStatus = chooseYourPlanPage.planAvailabilityStatus(planType);
    } else if (planType.equals("starter")) {
      planIsAvailableStatus = chooseYourPlanPage.planAvailabilityStatus(planType);
    } else if (planType.equals("professional")) {
      planIsAvailableStatus = chooseYourPlanPage.planAvailabilityStatus(planType);
    }
    return planIsAvailableStatus;
  }
}
