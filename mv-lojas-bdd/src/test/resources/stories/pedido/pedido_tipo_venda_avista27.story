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
@issue rgs-27
@rgs-27

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 139756
And Eu clico no icone detalhes do produto 139756
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219757
And Eu clico no icone detalhes do produto 219757
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega RETIRADA LOJA COM RETENCAO
And Eu informo a flag entrega como NÃO
And Eu informo uma data de retencao disponivel
And Eu clico no botao Reservar

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu clico em adicionar servico
And Eu adiciono o servico 209514
And Eu clico em adicionar servico
And Eu adiciono o servico 103514
And Eu altero a quantidade do servico 209514 para 2
And Eu valido se o servico 104141 ja foi adicionado
!-- And Eu altero o valor unitario do servico 104141 para 50,00

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

And Eu clico na aba Garantia
And Eu removo a garantia 144779 do produto 219757
And Eu informo o usuario 6699 e senha 1 para validar exclusao

And Eu clico na aba Produto
And Eu clico no produto 219757
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144779

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Cartao Redeshop
And Eu informo o valor da 1 ª forma de pagamento 200,00

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento V
And Eu seleciono a 2 ª forma de pagamento Cartao Visa Electron
And Eu informo o valor da 2 ª forma de pagamento 25,00

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 3 º tipo de pagamento V
And Eu seleciono a 3 ª forma de pagamento Cheque a vista
And Eu informo o valor da 3 ª forma de pagamento 300,00
And Eu clico no botao CMC7
And Eu informo o numero do cheque 237318420010034895777504362409
And Eu clico no botao validar CMC7
And Eu informo a data 01/2010 de abertura da conta do cheque
And Eu clico no botao Salvar Cheque

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 4 º tipo de pagamento V
And Eu seleciono a 4 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 22 - Ag. Lib. Credito Central

Scenario: Efetua 1ª reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-27
@rgs-27

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 219757
And Eu clico no botao Cancelar Reserva
!-- And Eu clico no botao Ok do modal

And Eu clico no icone detalhes do produto 219757
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 139550
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 139550
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu informo o numero de serie 0001
And Eu clico no botao Reservar

And Eu clico na aba Garantia
And Eu valido se a garantia 144765 foi adicionada para o produto 139756
And Eu valido se a garantia 142384 foi adicionada para o produto 139756
!-- And Eu valido se a garantia 192434 foi adicionada para o produto 139754
And Eu valido se a garantia 144765 foi adicionada para o produto 139754
!-- And Eu valido se a garantia 192434 foi adicionada para o produto 139763
And Eu valido se a garantia 144765 foi adicionada para o produto 139763
And Eu valido se a garantia 144779 foi adicionada para o produto 219757
And Eu valido se a garantia 143191 foi adicionada para o produto 139550

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor

Scenario: Efetua 2ª reabertura do pedido feito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-27
@rgs-27

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico na aba Serviços
And Eu removo o servico 103514
And Eu removo o servico 209514
!-- !-- And Eu altero a quantidade do servico 163594 para 3
And Eu altero o valor unitario do servico 104141 para 45,00
And Eu clico em adicionar servico
And Eu adiciono o servico 103519

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron
And Eu informo o valor da 1 ª forma de pagamento 25,00

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento V
And Eu seleciono a 2 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-27 no relatorio
