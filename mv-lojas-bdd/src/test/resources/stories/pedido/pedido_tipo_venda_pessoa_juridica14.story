Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO, e duas formas de pagamento cartão crédito e boleto
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-14
@rgs-14

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cnpj 51727323000112
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 2 - PESSOA JURIDICA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 215275
And Eu clico no icone detalhes do produto 215275
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega RETIRADA LOJA COM RETENCAO
And Eu informo a flag entrega como NÃO
And Eu informo uma data de retencao disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu informo um valor de entrada de 100,00

And Eu clico na aba Garantia
And Eu removo a garantia 140358 do produto 215275
And Eu clico na aba Produto
And Eu clico no produto 215275
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 140358

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento BOLETO BANCARIO
And Eu clico no botao Gerar Financiamento
And Eu informo o numero 000001 para o documento

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 22 - Ag. Lib. Credito Central


Scenario: Efetua a reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-14
@rgs-14

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 215275
And Eu clico no botao Cancelar Reserva
And Eu clico no botao Ok do modal

And Eu clico no icone detalhes do produto 215275
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega RETIRADA LOJA COM RETENCAO
And Eu informo a flag entrega como NÃO
And Eu informo uma data de retencao disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 16374
And Eu clico no icone detalhes do produto 16374
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega RETIRADA LOJA COM RETENCAO
And Eu informo a flag entrega como NÃO
And Eu informo uma data de retencao disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Garantia
And Eu valido se a garantia 140358 foi adicionada para o produto 215275
And Eu valido se a garantia 136711 foi adicionada para o produto 16374

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Dinheiro

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento BOLETO BANCARIO
And Eu clico no botao Gerar Financiamento
And Eu informo o numero 000001 para o documento

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 22 - Ag. Lib. Credito Central
And Eu salvo o pedido do teste @rgs-14 no relatorio
