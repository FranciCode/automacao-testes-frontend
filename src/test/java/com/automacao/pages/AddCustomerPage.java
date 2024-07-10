package com.automacao.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddCustomerPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "switch-version-select")
    private WebElement selectVersion;

    @FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")
    private WebElement addCustomerButton;

    @FindBy(id = "field-customerName")
    private WebElement customerNameField;

    @FindBy(id = "field-contactLastName")
    private WebElement lastNameField;

    @FindBy(id = "field-contactFirstName")
    private WebElement contactFirstNameField;

    @FindBy(id = "field-phone")
    private WebElement phoneField;

    @FindBy(id = "field-addressLine1")
    private WebElement addressLine1Field;

    @FindBy(id = "field-addressLine2")
    private WebElement addressLine2Field;

    @FindBy(id = "field-city")
    private WebElement cityField;

    @FindBy(id = "field-state")
    private WebElement stateField;

    @FindBy(id = "field-postalCode")
    private WebElement postalCodeField;

    @FindBy(id = "field-country")
    private WebElement countryField;

    @FindBy(xpath = "//*[@class=\"chosen-container chosen-container-single\"]/a[1]/div[1]/b")
    private  WebElement buttonSelect;

    @FindBy(xpath = "//*[@class=\"chosen-results\"]/li[1]")
    private  WebElement fromEmployeer;


    @FindBy(id = "field-salesRepEmployeeNumber")
    private WebElement fromEmployeerField;

    @FindBy(id = "field-creditLimit")
    private WebElement creditLimitField;

    @FindBy(id = "field-deleted")
    private WebElement deletedField;

    @FindBy(id = "form-button-save")
    private WebElement saveButton;

    @FindBy(id = "report-success")
    private WebElement successMessage;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void selectVersion(String version) {
        selectVersion.sendKeys(version);
    }

    public void clickAddCustomer() {
        addCustomerButton.click();
    }

    public void clickButtonSelect() {
        buttonSelect.click();
    }

    public void clickSelect() {
        fromEmployeer.click();
    }

    public void fillCustomerName(String customerName) {
        customerNameField.sendKeys(customerName);
    }

    public void fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillContactFirstName(String contactFirstName) {
        contactFirstNameField.sendKeys(contactFirstName);
    }

    public void fillPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void fillAddressLine1(String addressLine1) {
        addressLine1Field.sendKeys(addressLine1);
    }

    public void fillAddressLine2(String addressLine2) {
        addressLine2Field.sendKeys(addressLine2);
    }

    public void fillCity(String city) {
        cityField.sendKeys(city);
    }

    public void fillState(String state) {
        stateField.sendKeys(state);
    }

    public void fillPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void fillCountry(String country) {
        countryField.sendKeys(country);
    }

    public void fillCreditLimit(String creditLimit) {
        creditLimitField.sendKeys(creditLimit);
    }

    public void fillDeleted(String deleted) {
        deletedField.sendKeys(deleted);
    }

    public void clickSave() {
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
