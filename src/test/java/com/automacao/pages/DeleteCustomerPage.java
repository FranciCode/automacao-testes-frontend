package com.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
    private WebDriver driver;

    @FindBy(id = "switch-version-select")
    private WebElement selectVersion;

    @FindBy(name = "customerName")
    private WebElement searchNameField;

    @FindBy(xpath = "//*[@id='gcrud-search-form']/div[2]/table/thead/tr[2]/td[1]/div/input")
    private WebElement firstCheckbox;

    @FindBy(xpath = "//*[@class=\"filter-row gc-search-row\"]/td[2]/div")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class=\"btn btn-danger delete-multiple-confirmation-button\"]")
    private WebElement deleteAccept;

    @FindBy(xpath = "//*[@class='alert alert-success growl-animated animated bounceInDown']/span[3]/p")
    private WebElement successMessage;

    public DeleteCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectVersion(String version) {
        selectVersion.sendKeys(version);
    }

    public void selectNameCustomer(String customerName) {
        driver.findElement(By.name("customerName")).sendKeys(customerName);
        driver.findElement(By.tagName("body")).click();

    }

    public void searchCustomer(String customerName) {
        searchNameField.sendKeys(customerName);
    }

    public void selectFirstCustomerCheckbox() {
        firstCheckbox.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void deleteAccept() {
        deleteAccept.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}




