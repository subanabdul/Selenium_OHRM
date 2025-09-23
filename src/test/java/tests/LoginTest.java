package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.DashboardPage;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Test
    public void validLoginTest() {
        driver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be displayed after valid login");
    }

    @Test
    public void invalidLoginTest() {
        driver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("WrongUsername");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Invalid credentials", "Error message should say 'Invalid credentials' for wrong login");
    }

}