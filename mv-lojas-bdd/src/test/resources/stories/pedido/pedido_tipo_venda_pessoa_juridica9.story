Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM EMPENHO DEPOSITO
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/RETIRADA OUTRA LOJA COM EMPENHO DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-09
@rgs-09

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cnpj 51727323000112
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 2 - PESSOA JURIDICA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219494
And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu informo um valor de entrada de 100,00

And Eu clico na aba Garantia
!-- And Eu removo a garantia 209514 do produto 219494
And Eu valido se a garantia 139524 foi adicionada para o produto 219494

And Eu clico na aba Serviços
And Eu valido se o servico 104141 ja foi adicionado
And Eu clico em adicionar servico
And Eu adiciono o servico 139524

And Eu clico na aba Planilha
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

Scenario: Efetua a reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-09
@rgs-09

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 201791.4.0
And Eu clico no icone detalhes do produto 201791
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Garantia
And Eu removo a garantia 142383 do produto 201791
And Eu clico na aba Produto
And Eu clico no produto 201791
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 142383

And Eu clico na aba Serviços
And Eu valido se o servico 104141 ja foi adicionado

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
And Eu salvo o pedido do teste @rgs-09 no relatorio
