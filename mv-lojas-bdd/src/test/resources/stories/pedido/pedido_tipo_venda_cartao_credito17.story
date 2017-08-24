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
@issue rgs-17
@rgs-17

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 53 - CARTAO DE CREDITO

!-- And Eu pesquiso e seleciono o produto 208974.371.0
And Eu clico no botao adicionar produto
And Eu pesquiso o produto 208974
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 208974
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

!-- And Eu pesquiso e seleciono o produto 188774
And Eu clico no botao adicionar produto
And Eu pesquiso o produto 188774
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 188774
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega RETIRADA LOJA COM RETENCAO
And Eu informo a flag entrega como NÃO
And Eu informo uma data de retencao disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono a tabela 95 - TABELA 95 para o produto 208974
And Eu seleciono a tabela 95 - TABELA 95 para o produto 188774
And Eu informo um valor de entrada de 150,00
And Eu seleciono o plano 3 X

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Garantia
!-- And Eu removo a garantia 192434 do produto 208974
And Eu removo a garantia 144765 do produto 208974
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico na aba Produto
And Eu clico no produto 208974
And Eu clico na aba Garantia
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 192434
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144765

And Eu clico na aba Garantia
And Eu removo a garantia 140358 do produto 188774
And Eu removo a garantia 149535 do produto 188774
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico na aba Produto
And Eu clico no produto 188774
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 140358
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 149535

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Dinheiro

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento Cartao Visa

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
@issue rgs-17
@rgs-17

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 16374
And Eu clico no icone detalhes do produto 16374
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Serviços
!-- And Eu valido se o servico 163594 ja foi adicionado
And Eu valido se o servico 104141 ja foi adicionado
And Eu clico em adicionar servico
And Eu adiciono o servico 139524

And Eu clico na aba Garantia
!-- And Eu valido se a garantia 192434 foi adicionada para o produto 208974
And Eu valido se a garantia 144765 foi adicionada para o produto 208974
And Eu valido se a garantia 140358 foi adicionada para o produto 188774
And Eu valido se a garantia 149535 foi adicionada para o produto 188774
And Eu valido se a garantia 136711 foi adicionada para o produto 16374

And Eu informo um valor de entrada de 0,00
And Eu seleciono o plano 6 X

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Visa

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-17 no relatorio
