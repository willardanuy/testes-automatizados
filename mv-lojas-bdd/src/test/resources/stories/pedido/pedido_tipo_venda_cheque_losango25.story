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
@issue rgs-25
@rgs-25

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 67 - CHEQUE LOSANGO SCRED

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219494
And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como SIM
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono o plano 2 X

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 3

And Eu clico na aba Garantia
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

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cheque Losango
And Eu informo o numero do cheque 237318420010034895777504362409
And Eu clico no botao validar CMC7
And Eu informo a data 01/2010 de abertura da conta do cheque
And Eu clico no botao Salvar Cheque

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
@issue rgs-25
@rgs-25

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 219494
And Eu clico no botao Cancelar Reserva
And Eu clico no botao Ok do modal

And Eu clico no icone detalhes do produto 219494
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286
And Eu clico no botao Ok do modal

And Eu seleciono o plano 12 X

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 219494
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 219494
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
!-- And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cheque Losango
And Eu informo o numero do cheque 237318420010034895777504362409
And Eu clico no botao validar CMC7
And Eu informo a data 01/2010 de abertura da conta do cheque
And Eu clico no botao Salvar Cheque

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 22 - Ag. Lib. Credito Central

Scenario: Efetua a reabertura II do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-25
@rgs-25

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 139756
And Eu clico no icone detalhes do produto 139756
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu informo um valor de entrada de 400,00
And Eu seleciono o plano 6 X

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 3
!-- And Eu altero a quantidade do servico 209514 para 2

And Eu clico na aba Garantia
And Eu removo a garantia 144765 do produto 139756
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu removo a garantia 142384 do produto 139756
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu clico na aba Produto
And Eu clico no produto 139756
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144765
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 142384

And Eu clico na aba Garantia
!-- And Eu removo a garantia 192434 do produto 139754
And Eu removo a garantia 144765 do produto 139754
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu clico na aba Produto
And Eu clico no produto 139754
And Eu clico na aba Garantia
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 192434
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144765

And Eu clico na aba Garantia
!-- And Eu removo a garantia 192434 do produto 139763
And Eu removo a garantia 144765 do produto 139763
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu clico na aba Produto
And Eu clico no produto 139763
And Eu clico na aba Garantia
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 192434
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144765

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 219494
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 219494
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
!-- And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Dinheiro

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento Cheque Losango
And Eu informo o numero do cheque 237318420010034895777504362409
And Eu clico no botao validar CMC7
And Eu informo a data 01/2010 de abertura da conta do cheque
And Eu clico no botao Salvar Cheque

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 22 - Ag. Lib. Credito Central
And Eu salvo o pedido do teste @rgs-25 no relatorio
