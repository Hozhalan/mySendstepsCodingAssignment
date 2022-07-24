package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

  private final WebDriver driver;

  protected By tabCreditCard =
      By.xpath("//*[@id='sectionCheckout']//div[2]/div/div[2]/div[1]/div[1]/div[1]/div[1]");
  protected By tabIDeal =
      By.xpath("//*[@id='sectionCheckout']//div[2]/div/div[2]/div[1]/div[1]/div[1]/div[2]");
  protected By btnUpgradeNow = By.id("sntUpgradeBtn");
  protected By dropDown = By.xpath("//*[@id='sectionCheckout']//div[1]/div[1]/div[2]/div[1]/div");
  protected WebDriverWait wait;

  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
  }

  public void clickOnIDealTab() {
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(tabIDeal)).click();
  }

  public void clickOnCreditCardTab() {
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(tabCreditCard)).click();
  }

  public void selectTheCreditCardType(String creditCardType) {
    driver.findElement(dropDown).click();
    switch (creditCardType) {
      case "Master":
        driver
            .findElement(
                By.xpath("//*[@id='sectionCheckout']//div[1]/div[1]/div[2]/div[2]/span[1]"))
            .click();
        break;
      case "Visa":
        driver
            .findElement(
                By.xpath("//*[@id='sectionCheckout']//div[1]/div[1]/div[2]/div[2]/span[2]"))
            .click();
        break;
      case "American":
        driver
            .findElement(
                By.xpath("//*[@id='sectionCheckout']//div[1]/div[1]/div[2]/div[2]/span[3]"))
            .click();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + creditCardType);
    }
  }

  public Object clickUpgradeNowButton() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement element = driver.findElement(btnUpgradeNow);
    if (driver.findElement(tabCreditCard).getAttribute("class").contains("selected")) {
      js.executeScript("arguments[0].scrollIntoView();", element);
      js.executeScript("arguments[0].click();", element);
      return new CardPaymentDetailsPage(driver);
    } else if (driver.findElement(tabIDeal).getAttribute("class").contains("selected")) {
      js.executeScript("arguments[0].scrollIntoView();", element);
      js.executeScript("arguments[0].click();", element);
      return new SelectYourBankPage(driver);
    }
    return null;
  }
}
