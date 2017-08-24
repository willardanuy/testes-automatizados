Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em LOJA/NORMAL
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com LOJA/NORMAL e reabertura
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-07
@rgs-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219757
And Eu clico no icone detalhes do produto 219757
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar

And Eu clico na aba Garantia
And Eu removo a garantia 144779 do produto 219757
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico na aba Produto
And Eu clico no produto 219757
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144779

!-- And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
!-- And Eu clico em adicionar servico
!-- And Eu adiciono o servico 163594

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

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
@issue rgs-07
@rgs-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 219494
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como SIM
And Eu clico no botao Reservar

And Eu clico na aba Garantia
And Eu valido se a garantia 144779 foi adicionada para o produto 219757
And Eu removo a garantia 196014 do produto 219494
And Eu removo a garantia 139524 do produto 219494
And Eu removo a garantia 144776 do produto 219494
And Eu informo o usuario 6699 e senha 1 para validar exclusao
!-- And Eu removo a garantia 209514 do produto 219494

And Eu clico na aba Produto
And Eu clico no produto 219494
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144775

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 4
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-07 no relatorio
