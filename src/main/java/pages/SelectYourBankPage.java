package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectYourBankPage {

  private final WebDriver driver;

  protected By dropDownCardExpiryYear = By.xpath("//select[@id='idealIssuerId']");
  protected By btnBack = By.xpath("//*[@id='mainBack']");
  protected By btnProceed = By.xpath("//*[@id='mainSubmit']");

  public SelectYourBankPage(WebDriver driver) {
    this.driver = driver;
  }

  public void selectYourBank() {
    Select dropDownForMonth = new Select(driver.findElement(dropDownCardExpiryYear));
    dropDownForMonth.selectByVisibleText("Test Issuer 3");
  }

  public IDealIssuerSimulationPage clickProceedButton() {
    driver.findElement(btnProceed).click();
    return new IDealIssuerSimulationPage(driver);
  }

  public CheckoutPage clickBackButton() {
    driver.findElement(btnBack).click();
    return new CheckoutPage(driver);
  }
}
