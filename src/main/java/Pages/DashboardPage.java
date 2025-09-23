package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Locator for something visible on dashboard, e.g., a header or breadcrumb
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    // Or other reliable element for knowing login succeeded

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        try {
            return driver.findElement(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
