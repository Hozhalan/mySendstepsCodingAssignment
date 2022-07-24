package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

  private final WebDriver driver;

  protected By txtEmailAddress = By.xpath("//input[@id='mui-21']");
  protected By txtPassword = By.xpath("//input[@id='mui-22']");
  protected By btnContinue = By.xpath("//button[text()='Continue']");
  protected By btnLoginNow = By.xpath("//button[text()='Login Now']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterTheEmailAddress(String emailAddress) {
    driver.findElement(txtEmailAddress).sendKeys(emailAddress);
    driver.findElement(btnContinue).click();
  }

  public void enterThePassword(String password) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
  }

  public UserHomePage clickLoginNowButton() {
    driver.findElement(btnLoginNow).click();
    return new UserHomePage(driver);
  }
}
