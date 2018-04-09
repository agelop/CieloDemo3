#Feature: <feature title>
#
#  Scenario: <scenario title>
#    Given <pre-condition statement>
#    When <action statement>
#    Then <expectation statement>
#
#  Scenario Outline: <scenario title>
#    Given <pre-condition statement>
#    When <action statement>
#    Then <expectation statement>
#
#    Examples:
#
#      | arg1      | arg2     |
#      | "value1"  | "value2" |
#      #more values here
#
#
Feature: Compras Online

  Scenario: Verificar Ofertas de Itens Populares
    Given User entra no portal de compras online
    When Seleciona link de Itens Populares
    And Adiciona o primeiro item ao carrinho
    And Navega para o carrinho
    Then O carrinho atualizado com o item

  Scenario Outline: Checar Precos dos Produtos
    Given User entra no portal de compras online
    When Seleciona a categoria <categoria>
    And Adiciona o primeiro produto ao carrinho
    And Navega para o carrinho
    Then O preco total mostrado <preco>

    Examples: 
      | categoria | preco   |
      | speakers  | $269.99 |
      | mice      | $9.99   |
