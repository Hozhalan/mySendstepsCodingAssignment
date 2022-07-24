package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class IDealIssuerSimulationPage {

  private final WebDriver driver;
  protected By btnContinue = By.xpath("//form/table/tbody/tr[6]/td[1]/input");

  public IDealIssuerSimulationPage(WebDriver driver) {
    this.driver = driver;
  }

  public UserHomePage clickContinueButton() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    driver.findElement(btnContinue).click();
    return new UserHomePage(driver);
  }
}
