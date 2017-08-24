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
@issue rgs-28
@rgs-28

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

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

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 219494
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 201791.4.0
And Eu clico no icone detalhes do produto 201791
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como NÃO
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar

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

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu clico em adicionar servico
And Eu adiciono o servico 139524
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Garantia
And Eu valido se a garantia 149535 foi adicionada para o produto 187574
And Eu valido se a garantia 142383 foi adicionada para o produto 201791
And Eu removo a garantia 140358 do produto 187574
And Eu removo a garantia 139524 do produto 219494
And Eu removo a garantia 144776 do produto 219494
And Eu informo o usuario 6699 e senha 1 para validar exclusao
!-- And Eu removo a garantia 209514 do produto 219494
And Eu removo a garantia 196014 do produto 219494
And Eu removo a garantia 144765 do produto 201791
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Efetua 1ª reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-28
@rgs-28

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 187574
And Eu clico no botao Cancelar Reserva

And Eu clico no icone detalhes do produto 187574
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar

And Eu clico no icone detalhes do produto 219494
And Eu clico no botao Cancelar Reserva

And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar

And Eu clico no icone detalhes do produto 201791
And Eu clico no botao Cancelar Reserva

And Eu clico no icone detalhes do produto 201791
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar

And Eu clico no icone detalhes do produto 219494
And Eu clico no botao Cancelar Reserva
And Eu removo o produto 219494

And Eu clico na aba Garantia
And Eu valido se a garantia 149535 foi adicionada para o produto 187574
And Eu valido se a garantia 142383 foi adicionada para o produto 201791

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron
And Eu informo o valor da 1 ª forma de pagamento 15,00

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento V
And Eu seleciono a 2 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-28 no relatorio
