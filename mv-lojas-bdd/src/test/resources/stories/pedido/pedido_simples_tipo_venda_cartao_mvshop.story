Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO, e duas formas de pagamento cartão crédito e boleto
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido CARTAO MVSHOP
Meta:
@tag component:VIRADA CL X CS - MVSH
@context VIRADA CL X CS
@base MVSH
@grupoInstancias Pedidos
@issue virada-pedido-mvshop
@virada-pedido-mvshop

Given Eu acesso a instancia padrao
When Eu faco login na loja 140 com usuario 7380 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 70 - CARTAO MVSHOP

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 300785
And Eu clico no icone detalhes do produto 300785
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono o plano 1 X

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento MV Shop Reabertura

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Elaborar um pedido CARTAO MVSHOP
Meta:
@tag component:VIRADA CL X CS - MVSH
@context VIRADA CL X CS
@base MVSH
@grupoInstancias Pedidos
@issue virada-pedido-mvshop
@virada-pedido-mvshop

Given Eu acesso a instancia padrao
When Eu faco login na loja 140 com usuario 7380 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 70 - CARTAO MVSHOP

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 300785
And Eu clico no icone detalhes do produto 300785
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono o plano 8 X

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento MV Shop Reabertura

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor