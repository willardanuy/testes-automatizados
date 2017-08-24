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
@issue rgs-24
@rgs-24

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 57 - CARTAO RICARDO ELETR

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 201791
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 201791
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291
And Eu clico no botao Ok do modal

And Eu seleciono a tabela 96 - TABELA 96 (PLU$) para o produto 201791
And Eu seleciono o plano 4 X

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu clico em adicionar servico
And Eu adiciono o servico 139524

And Eu clico na aba Garantia
And Eu removo a garantia 144765 do produto 201791
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu removo a garantia 142383 do produto 201791

And Eu clico na aba Produto
And Eu clico no produto 201791
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144765
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 142383

!-- And Eu informo o valor da prestacao 58,00

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Ricardo Eletr

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
@issue rgs-24
@rgs-24

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 187574
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 187574
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286
And Eu clico no botao Ok do modal

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219494
And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como SIM
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono o plano 4 X

And Eu clico na aba Serviços
!-- And Eu removo o servico 209514
!-- And Eu altero a quantidade do servico 209514 para 3
!-- !-- And Eu altero a quantidade do servico 163594 para 5
And Eu altero o valor unitario do servico 104141 para 35,00
And Eu valido se o servico 139524 ja foi adicionado

And Eu clico na aba Garantia
And Eu valido se a garantia 144765 foi adicionada para o produto 201791
And Eu valido se a garantia 142383 foi adicionada para o produto 201791

And Eu valido se a garantia 149535 foi adicionada para o produto 187574
And Eu valido se a garantia 140358 foi adicionada para o produto 187574

And Eu valido se a garantia 139524 foi adicionada para o produto 219494
And Eu valido se a garantia 144776 foi adicionada para o produto 219494

And Eu removo a garantia 196014 do produto 219494
And Eu removo a garantia 139524 do produto 219494
And Eu removo a garantia 144776 do produto 219494
And Eu informo o usuario 6699 e senha 1 para validar exclusao
!-- And Eu removo a garantia 209514 do produto 219494

And Eu clico na aba Produto
And Eu clico no produto 219494
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 196014
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 139524
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144776
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 209514

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 187574
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 187574
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
!-- And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Ricardo Eletr

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-24 no relatorio
