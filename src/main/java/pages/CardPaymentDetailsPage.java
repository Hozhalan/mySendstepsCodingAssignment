package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CardPaymentDetailsPage {

  private final WebDriver driver;
  protected By txtCardNumber = By.xpath("//input[@id='card.cardNumber']");
  protected By txtCardHolderName = By.xpath("//*[@id='card.cardHolderName']");
  protected By dropDownCardExpiryMonth = By.xpath("//select[@id='card.expiryMonth']");
  protected By dropDownCardExpiryYear = By.xpath("//select[@id='card.expiryYear']");
  protected By txtCVV = By.xpath("//input[@id='card.cvcCode']");
  protected By btnBack = By.xpath("//*[@id='mainBack']");
  protected By btnProceed = By.xpath("//*[@id='mainSubmit']");
  protected By txtErrorValidation = By.xpath("//*[@id='errorFrameValidationErrors']/span");
  protected Select dropDownForMonth;
  protected Select dropDownForYear;

  public CardPaymentDetailsPage(WebDriver driver) {
    this.driver = driver;
    dropDownForMonth = new Select(driver.findElement(dropDownCardExpiryMonth));
    dropDownForYear = new Select(driver.findElement(dropDownCardExpiryYear));
  }

  public void enterCardDetails(
      String cardNumber, String cardHolderName, String month, String year, String cVV) {
    driver.findElement(txtCardNumber).sendKeys(cardNumber);
    driver.findElement(txtCardHolderName).sendKeys(cardHolderName);
    dropDownForMonth.selectByValue(month);
    dropDownForYear.selectByValue(year);
    driver.findElement(txtCVV).sendKeys(cVV);
  }

  public PaymentCompletePage clickProceedButton() {
    driver.findElement(btnProceed).click();
    return new PaymentCompletePage(driver);
  }

  public String getErrorValidationTest() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(txtErrorValidation)).getText();
  }

  public CheckoutPage clickBackButton() {
    driver.findElement(btnBack).click();
    return new CheckoutPage(driver);
  }
}
