Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/AGENDADA CLIENTE e um reempenho em DEPOSITO/AGENDADA
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/AGENDADA CLIENTE
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-02
@rgs-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 16376
And Eu clico no icone detalhes do produto 16376
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como SIM
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 187374
And Eu clico no icone detalhes do produto 187374
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como SIM
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar

And Eu clico no produto 187374
And Eu clico na aba Garantia
And Eu removo a garantia 140358 do produto 187374
And Eu removo a garantia 144658 do produto 187374
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144658

And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 140358
And Eu valido se a garantia 215914 foi adicionada para o produto 187374
And Eu valido se a garantia 136711 foi adicionada para o produto 16376

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 2
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Efetua o reempenho do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-02
@rgs-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 187374
And Eu clico no botao Cancelar Reserva

And Eu clico no icone detalhes do produto 187374
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Garantia
And Eu valido se a garantia 140358 foi adicionada para o produto 187374
And Eu valido se a garantia 144658 foi adicionada para o produto 187374
And Eu valido se a garantia 136711 foi adicionada para o produto 16376

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-02 no relatorio
