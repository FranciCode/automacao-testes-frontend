package com.automation.stepDefinitions;

import com.automacao.pages.AddCustomerPage;
import com.automation.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddCustomerSteps {
    private WebDriver driver;
    private AddCustomerPage addCustomerPage;

    @Before
    public void setUp() {
        driver = WebDriverUtils.getDriver();
        addCustomerPage = new AddCustomerPage(driver);
    }

    @When("Abro o site {string}")
    public void iOpenTheWebsite(String url) {
        driver.get(url);
    }

    @When("Seleciono a versão {string}")
    public void iSelectVersion(String version) {
        addCustomerPage.selectVersion(version);
    }

    @When("Clico no botão Adicionar cliente")
    public void iClickOnAddCustomerButton() {
        addCustomerPage.clickAddCustomer();
    }

    @When("Preencho o formulário do cliente com dados válidos")
    public void iFillTheCustomerFormWithValidData() {
        addCustomerPage.fillCustomerName("Bianca");
        addCustomerPage.fillLastName("Costa");
        addCustomerPage.fillContactFirstName("Bia");
        addCustomerPage.fillPhone("8396885377");
        addCustomerPage.fillAddressLine1("Rua Feliz, 94");
        addCustomerPage.fillAddressLine2("Apto. 123");
        addCustomerPage.fillCity("João Pessoa");
        addCustomerPage.fillState("PB");
        addCustomerPage.fillPostalCode("58000000");
        addCustomerPage.fillCountry("Brasil");
        addCustomerPage.clickButtonSelect();
        addCustomerPage.clickSelect();
        addCustomerPage.fillCreditLimit("25.000");
        addCustomerPage.fillDeleted(" ");
    }

    @When("Clico no botão Salvar")
    public void iClickOnSaveButton() {
        addCustomerPage.clickSave();
    }

    @Then("Devo ver uma mensagem de sucesso {string}")
    public void iShouldSeeASuccessMessage(String expectedMessage) {
        String actualMessage = addCustomerPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        WebDriverUtils.closeDriver();
    }
}