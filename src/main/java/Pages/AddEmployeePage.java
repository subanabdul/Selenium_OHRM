package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
    public WebDriver driver;

    public By addEmployeeButton = By.xpath("//button[normalize-space()='Add']");
    public By firstNameInput = By.xpath("//*[@name=\"firstName\"]");
    public By lastNameInput = By.xpath("//*[@name=\"lastName\"]");
    public By saveButton = By.xpath("//button[normalize-space()='Save']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddEmployee() {
        driver.findElement(addEmployeeButton).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstNameInput).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastNameInput).sendKeys(lname);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }
}
