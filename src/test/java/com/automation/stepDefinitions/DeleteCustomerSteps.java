package com.automation.stepDefinitions;

import com.automacao.pages.DeleteCustomerPage;
import com.automation.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteCustomerSteps {
    private WebDriver driver;
    private DeleteCustomerPage deleteCustomerPage;

    @Before
    public void setUp() {
        driver = WebDriverUtils.getDriver();
        deleteCustomerPage = new DeleteCustomerPage(driver);
    }

    @When("Eu procuro o cliente {string}")
    public void iSearchForTheCustomer(String customerName) {
        deleteCustomerPage.searchCustomer(customerName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='gcrud-search-form']/div[2]/table/tbody/tr[1]")));
    }

    @When("Eu seleciono a primeira caixa de seleção do cliente")
    public void iSelectTheFirstCustomerCheckbox() {
        deleteCustomerPage.selectFirstCustomerCheckbox();
        deleteCustomerPage.clickDelete();
    }

    @When("Clico no botão Delete")
    public void iClickOnDeleteButton() {
        deleteCustomerPage.deleteAccept();
    }

    @Then("Devo ver uma mensagem de confirmação de exclusão {string}")
    public void iShouldSeeADeleteConfirmationMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@class='alert alert-success growl-animated animated bounceInDown']/span[3]/p")));
        String actualMessage = deleteCustomerPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage.trim(), actualMessage);
    }

    @After
    public void tearDown() {
        WebDriverUtils.closeDriver();
    }
}
