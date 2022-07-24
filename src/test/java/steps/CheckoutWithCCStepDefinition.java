package steps;

import base.BaseTests;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CardPaymentDetailsPage;
import pages.PaymentCompletePage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CheckoutWithCCStepDefinition extends BaseTests {

  @Then(
      "verify user can select the {string} plan and proceed to checkout with {string} credit card details")
  public void verify_user_can_select_a_plan_and_proceed_with_the_credit_card_payment_successfully(
      String planType, String creditCardType) throws IOException {

    WebElement availabilityStatus = checkWhetherThePlanIsAvailable(planType);
    if (availabilityStatus.getAttribute("class").contains("disabled")) {
      Assert.assertEquals("Not available", availabilityStatus.getText());

    } else {
      checkoutPage = chooseYourPlanPage.selectThePlan(planType);
      checkoutPage.clickOnCreditCardTab();
      selectTheCreditCardAndEnterTheDetails(creditCardType);

      if (creditCardType.equals("invalid")) {
        cardPaymentDetailsPage.clickProceedButton();
        String errorValidationTest = cardPaymentDetailsPage.getErrorValidationTest();
        Assert.assertEquals("Invalid Card Number", errorValidationTest);
      } else {
        PaymentCompletePage paymentCompletePage = cardPaymentDetailsPage.clickProceedButton();
        userHome = paymentCompletePage.clickProceedButton();
        String dialogContentText = userHome.getDialogContentText();

        Assert.assertEquals("Thank you for your purchase!", dialogContentText);
      }
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

  public void selectTheCreditCardAndEnterTheDetails(String creditCardType) throws IOException {
    FileReader reader = null;
    Properties properties = new Properties();

    switch (creditCardType) {
      case "Master":
        reader = new FileReader("src/test/resources/creditCard/MasterCreditCardDetails");
        checkoutPage.selectTheCreditCardType("Master");
        break;
      case "Visa":
        reader = new FileReader("src/test/resources/creditCard/VisaCreditCardDetails");
        checkoutPage.selectTheCreditCardType("Visa");
        break;
      case "American":
        reader = new FileReader("src/test/resources/creditCard/AmericanCreditCardDetails");
        checkoutPage.selectTheCreditCardType("American");
        break;
      case "invalid":
        reader = new FileReader("src/test/resources/creditCard/InvalidCreditCardDetails");
        checkoutPage.selectTheCreditCardType("Master");
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + creditCardType);
    }

    properties.load(reader);
    cardPaymentDetailsPage = (CardPaymentDetailsPage) checkoutPage.clickUpgradeNowButton();
    cardPaymentDetailsPage.enterCardDetails(
        properties.getProperty("cardNumber"),
        properties.getProperty("cardHolderName"),
        properties.getProperty("month"),
        properties.getProperty("year"),
        properties.getProperty("cVV"));
  }
}
