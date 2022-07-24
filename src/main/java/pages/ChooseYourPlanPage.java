package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ChooseYourPlanPage {

  private final WebDriver driver;

  protected By btnSelectFreePlan =
      By.xpath("//*[@id='pricingOverview']/div[1]/div[1]/div[2]/div/a");
  protected By btnSelectStarterPlan =
      By.xpath("//*[@id='pricingOverview']/div[1]/div[2]/div[2]/div/a");
  protected By btnSelectProfessionalPlan =
      By.xpath("//*[@id='pricingOverview']/div[1]/div[3]/div[2]/div/a");

  public ChooseYourPlanPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement planAvailabilityStatus(String planType) {
    WebElement selectedButtonTextValue = null;
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    switch (planType) {
      case "free":
        selectedButtonTextValue = driver.findElement(btnSelectFreePlan);
        break;
      case "starter":
        selectedButtonTextValue = driver.findElement(btnSelectStarterPlan);
        break;
      case "professional":
        selectedButtonTextValue = driver.findElement(btnSelectProfessionalPlan);
        break;
      default:
        return null;
    }
    return selectedButtonTextValue;
  }

  public CheckoutPage selectThePlan(String planType) {
    switch (planType) {
      case "free":
        driver.findElement(btnSelectFreePlan).click();
        break;
      case "starter":
        driver.findElement(btnSelectStarterPlan).click();
        break;
      case "professional":
        driver.findElement(btnSelectProfessionalPlan).click();
        break;
      default:
        return null;
    }
    return new CheckoutPage(driver);
  }
}
