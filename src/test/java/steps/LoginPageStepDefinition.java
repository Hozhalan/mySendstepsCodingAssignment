package steps;

import base.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPageStepDefinition extends BaseTests {

  @Before
  public void stepUp() {
    startUp();
  }

  @Given("the user should be on the login page")
  public void the_user_should_be_on_the_login_page() {
    driver.navigate().to(route);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GLOBAL_TIMEOUT));
    loginPage = new LoginPage(driver);
  }

  @And("the user should enter the credentials and click on the 'LoginNow' button")
  public void the_user_should_enter_the_credentials_and_click_on_the_LoginNow_button()
      throws IOException {

    FileReader reader = new FileReader("src/test/resources/users/LoginDetails");
    Properties properties = new Properties();
    properties.load(reader);

    loginPage.enterTheEmailAddress(properties.getProperty("email"));
    loginPage.enterThePassword(properties.getProperty("password"));
    userHomePage = loginPage.clickLoginNowButton();
  }

  @And("the user should click on the 'UpdateMyAccount' button")
  public void the_user_should_click_on_the_UpdateMyAccount_button() {
    chooseYourPlanPage = userHomePage.clickUpdateMyAccountButton();
  }

  @After
  public void quitBrowser() {
    teardown();
  }
}
