Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO, e duas formas de pagamento cartão crédito e boleto
HERO BASICO
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-46
@rgs-46

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550

And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 144366
And Eu clico no icone detalhes do produto 144366
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu informo o numero de serie 0001
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291

!-- And Eu clico na aba Garantia
!-- And Eu removo a garantia 297315 do produto 144366

And Eu clico na aba Serviços
And Eu clico em adicionar servico
And Eu adiciono o servico 297315

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Efetua a reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-46
@rgs-46

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 189137.315.0
And Eu clico no icone detalhes do produto 189137
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291
!-- And Eu clico no botao Ok do modal

!-- And Eu clico na aba Garantia
!-- And Eu removo a garantia 192434 do produto 189137
!-- And Eu clico na aba Produto
!-- And Eu clico no produto 189137
!-- And Eu clico na aba Garantia
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 192434

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Efetua o recebimento do pedido
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Caixa
@issue rgs-46
@rgs-46

Given Eu acesso o pdv web padrao
When Eu faco login no pdv web 110 na loja 291 com usuario 7349 e senha 1
And Eu acesso o pdv menu Pedido
And No pdv eu pesquiso o pedido
And No pdv eu clico no botao receber pedido
And No pdv eu preencho os valores
And No pdv eu clico no botao Emitir Cupom
Then No pdv eu valido se o pedido foi recebido

Scenario: Imprimir termo de adesão do antivirus hero
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-46
@rgs-46

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Imprimir Documentos
And Eu seleciono o documento TERMO ADESÃO ANTIVÍRUS HERO
And Eu clico no botao Gerar Relatorio
Then Eu valido o Termo de Adesão Antivirus Hero
And Eu salvo o pedido do teste @rgs-46 no relatorio
