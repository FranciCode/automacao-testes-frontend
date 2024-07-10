Feature: Delete Customer

    Scenario: Successfully delete an existing customer
        Given Abro o site "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme"
        When Seleciono a versão "Bootstrap V4 Theme"
        And Eu procuro o cliente "Bianca"
        And Eu seleciono a primeira caixa de seleção do cliente
        And Clico no botão Delete
        Then Devo ver uma mensagem de confirmação de exclusão "Your data has been successfully deleted from the database."
