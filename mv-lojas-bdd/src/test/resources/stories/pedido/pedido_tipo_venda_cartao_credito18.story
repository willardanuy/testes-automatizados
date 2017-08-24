Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO, e duas formas de pagamento cartão crédito e boleto
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-18
@rgs-18

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 53 - CARTAO DE CREDITO

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 214954
And Eu clico no icone detalhes do produto 214954
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291
And Eu clico no botao Ok do modal

!-- And Eu clico no botao adicionar produto
!-- And Eu pesquiso e seleciono o produto 139550

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 139550
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 139550
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo o numero de serie 0001
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu seleciono a tabela 95 - TABELA 95 para o produto 214954
And Eu seleciono a tabela 95 - TABELA 95 para o produto 139550
And Eu seleciono o plano 12 X
And Eu informo o valor da prestacao 50,00

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 2
And Eu clico em adicionar servico
And Eu adiciono o servico 209514

And Eu clico na aba Garantia
And Eu removo a garantia 196014 do produto 214954
!-- And Eu removo a garantia 139524 do produto 214954
And Eu removo a garantia 144776 do produto 214954
And Eu informo o usuario 6699 e senha 1 para validar exclusao
!-- And Eu removo a garantia 209514 do produto 214954
And Eu clico na aba Produto
And Eu clico no produto 214954
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 196014
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 139524
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144776

And Eu clico na aba Garantia
And Eu removo a garantia 143191 do produto 139550
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico na aba Produto
And Eu clico no produto 139550
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 143191

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C para o produto 214954
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C para o produto 214954
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C,D para o produto 139550
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C,D para o produto 139550
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Mastercard

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
@issue rgs-18
@rgs-18

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no icone detalhes do produto 139550
And Eu clico no botao Cancelar Reserva
And Eu clico no botao Ok do modal

And Eu clico no icone detalhes do produto 139550
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como SIM
And Eu informo o numero de serie 0001
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286
And Eu clico no botao Ok do modal

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 219757
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 219757
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo a flag entrega como SIM
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu informo um valor de entrada de 200,00
And Eu seleciono o plano 3 X

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 139550
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 139550
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
!-- And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C para o produto 214954
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C para o produto 214954
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C,D para o produto 139550
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE PRECO com flags C,D para o produto 139550
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu informo o usuario 291 e senha 1 para validar liberacao
And Eu clico no botao Ok do modal


And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 3
And Eu altero o valor unitario do servico 104141 para 30,00

And Eu clico na aba Garantia
And Eu valido se a garantia 196014 foi adicionada para o produto 214954
And Eu valido se a garantia 139524 foi adicionada para o produto 214954
And Eu valido se a garantia 144776 foi adicionada para o produto 214954

And Eu removo a garantia 144779 do produto 219757
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico na aba Produto
And Eu clico no produto 219757
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 144779

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Dinheiro

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento Cartao Visa

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-18 no relatorio
