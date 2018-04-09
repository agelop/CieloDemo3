Feature: Compras Online

  Scenario: Verificar Ofertas de Itens Populares
    Given User entra no portal de compras online
    When Seleciona link de Itens Populares
    And Adiciona o primeiro item ao carrinho
    And Navega para o carrinho
    Then O carrinho atualizado com o item