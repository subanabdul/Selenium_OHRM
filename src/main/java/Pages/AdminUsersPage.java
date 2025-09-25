package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage {
    public WebDriver driver;
    private WebDriverWait wait;

    public By addButton = By.xpath("//button[normalize-space()='Add']");
    // fields on the Add User form
    public By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    public By userRoleOptionAdmin = By.xpath("//div[@role='option' and normalize-space()='Admin']");
    public By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    public By usernameInput = By.xpath("//label[text()='Username']/following::input[1]");
    public By statusDropdown = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-wrapper')][1]");
    public By statusOptionEnabled = By.xpath("//div[@role='option' and normalize-space()='Enabled']");
    public By passwordInput = By.xpath("//label[text()='Password']/following::input[1]");
    public By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    public By saveButton = By.xpath("//button[normalize-space()='Save']");

    public AdminUsersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void clickAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        driver.findElement(addButton).click();
    }


    public void selectUserRoleAsAdmin() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
        actions.moveToElement(driver.findElement(userRoleDropdown)).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleOptionAdmin));
        actions.moveToElement(driver.findElement(userRoleOptionAdmin)).click().perform();
    }

    public void enterEmployeeName(String empName) {
        wait.until(ExpectedConditions.elementToBeClickable(employeeNameInput));
        driver.findElement(employeeNameInput).sendKeys(empName);
        // optionally, wait for the suggestion and select
    }

    public void enterUsername(String uname) {
        driver.findElement(usernameInput).sendKeys(uname);
    }

    public void selectStatusEnabled() {
        driver.findElement(statusDropdown).click();
        driver.findElement(statusOptionEnabled).click();
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        driver.findElement(confirmPasswordInput).sendKeys(pwd);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }
}
