package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserHomePage {

  private final WebDriver driver;

  protected By btnUpdateMyAccount = By.xpath("//header/div[1]/div/button");
  protected By muiDialogContent = By.xpath("//body/div[2]/div[3]/div/div");
  protected By txtDialogContent = By.xpath("//body/div[2]/div[3]/div/div/h2");
  protected By btnReviewMyOrder = By.xpath("//div[2]/div[3]/div/div/div[2]/button");

  private WebDriverWait wait;

  public UserHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public ChooseYourPlanPage clickUpdateMyAccountButton() {
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpdateMyAccount)).click();
    return new ChooseYourPlanPage(driver);
  }

  public String getDialogContentText() {
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(muiDialogContent));
    return driver.findElement(txtDialogContent).getText();
  }
}
