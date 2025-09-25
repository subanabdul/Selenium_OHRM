package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class OrangeHRMTests extends BaseTest {

    @Test(priority = 1)
    public void testLoginAndDashboard() {
        LoginPage login = new LoginPage(driver);
        login.goToLoginPage();
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isAtDashboard(), "Dashboard is not displayed after login");
    }

    @Test(priority = 2, dependsOnMethods = {"testLoginAndDashboard"})
    public void testAddUser() {
        DashboardPage dash = new DashboardPage(driver);
        dash.clickAdminMenu();

        AdminUsersPage admin = new AdminUsersPage(driver);
        admin.clickAddUser();
        admin.selectUserRoleAsAdmin();
        admin.enterEmployeeName("Odis Adalwin");  // or any name that exists
        admin.enterUsername("testuser123");
        admin.selectStatusEnabled();
        admin.enterPassword("Password@123");
        admin.enterConfirmPassword("Password@123");
        admin.clickSave();

        // After save, you can add assertion that new user is listed, etc.
    }

    @Test(priority = 3, dependsOnMethods = {"testLoginAndDashboard"})
    public void testAddEmployee() {
        DashboardPage dash = new DashboardPage(driver);
        dash.clickPimMenu();

        AddEmployeePage addEmp = new AddEmployeePage(driver);
        addEmp.clickAddEmployee();
        addEmp.enterFirstName("John");
        addEmp.enterLastName("Doe");
        addEmp.clickSave();

        // add assertions like name shown in details page etc.
    }

    @Test(priority = 4, dependsOnMethods = {"testLoginAndDashboard"})
    public void testLogout() {
        DashboardPage dash = new DashboardPage(driver);
        dash.logout();

        // After logout, check that login page is shown again
        LoginPage login = new LoginPage(driver);
        // maybe check presence of login button or URL
        // e.g. Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
    }
}
