package base;

import org.openqa.selenium.WebDriver;
import pages.CardPaymentDetailsPage;
import pages.CheckoutPage;
import pages.ChooseYourPlanPage;
import pages.LoginPage;
import pages.SelectYourBankPage;
import pages.UserHomePage;
import utils.WebDriverLibrary;

public abstract class BaseTests {

  protected static final int GLOBAL_TIMEOUT = 5;
  protected static WebDriver driver;
  protected static String route = "https://web.staging.sendsteps.ninja/";

  protected static LoginPage loginPage;
  protected static UserHomePage userHomePage;
  protected static ChooseYourPlanPage chooseYourPlanPage;
  protected static CheckoutPage checkoutPage;
  protected static CardPaymentDetailsPage cardPaymentDetailsPage;
  protected static UserHomePage userHome;
  protected static SelectYourBankPage selectYourBankPage;

  public static void startUp() {
    driver = WebDriverLibrary.getChromeDriver();
  }

  public static void teardown() {
    driver.quit();
  }
}
