package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentCompletePage {

  private final WebDriver driver;

  protected By btnProceed = By.xpath("//*[@id='mainSubmit']");

  public PaymentCompletePage(WebDriver driver) {
    this.driver = driver;
  }

  public UserHomePage clickProceedButton() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(btnProceed)).click();
    return new UserHomePage(driver);
  }
}
