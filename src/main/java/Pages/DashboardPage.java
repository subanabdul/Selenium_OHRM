package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    public WebDriver driver;

    // Example: locator for “Dashboard” header or some unique element
    public By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    // Locator for “Admin” menu
    public By menuAdmin = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");
    public By menuPim = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");

    // Logout / user dropdown
    public By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    public By logoutOption = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAtDashboard() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public void clickAdminMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menuAdmin));
        driver.findElement(menuAdmin).click();
    }

    public void clickPimMenu() {
        driver.findElement(menuPim).click();
    }

    public void logout() {
        driver.findElement(userDropdown).click();
        driver.findElement(logoutOption).click();
    }
}
