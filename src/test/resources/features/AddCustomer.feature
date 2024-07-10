Feature: Add Customer

    Scenario: Successfully add a new customer
        Given Abro o site "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme"
        When Seleciono a versão "Bootstrap V4 Theme"
        And Clico no botão Adicionar cliente
        And Preencho o formulário do cliente com dados válidos
        And Clico no botão Salvar
        Then Devo ver uma mensagem de sucesso "Your data has been successfully stored into the database. Edit Customer or Go back to list"
