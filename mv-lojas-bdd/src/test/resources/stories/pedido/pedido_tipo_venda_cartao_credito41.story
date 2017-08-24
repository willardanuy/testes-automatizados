Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com garantia avulsa - venda externa e realizar reabertura para incluir um produto
De modo que o pedido seja criado ao finalizar o processo
					 
Scenario: Elaborar um pedido com garantia avulsa - venda externa
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-41
@rgs-41

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 53 - CARTAO DE CREDITO

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu clico no botao adicionar Garantia Avulsa

And Eu clico na aba Venda externa
And Eu informo o numero da nota fiscal venda externa
And Eu informo a data emissao da nota externa
And Eu informo a empresa da nota externa ELETRO SHOPPING
And Eu clico no icone pesquisar produto da venda externa
And Eu informo o codigo pai do produto 215275 da venda externa
And Eu clico no botao Pesquisar da venda externa
And Eu seleciono o produto 215275 para garantia avulsa venda externa
And Eu seleciono uma garantia avulsa GARANTIA MAIOR TV LCD - 1 ANO
And Eu clico no botao Inserir Garantia
And Eu clico no botao Ok do modal

And Eu clico no botao Salvar
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
@issue rgs-41
@rgs-41

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
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico no botao Ok do modal

And Eu clico na aba Serviços
And Eu clico no botao adicionar Garantia Avulsa

And Eu clico na aba Venda externa
And Eu clico na garantia avulsa na grid da venda externa
And Eu clico no botao para remover garantia avulsa na grid da venda externa

And Eu informo o numero da nota fiscal venda externa
And Eu informo a data emissao da nota externa
And Eu informo a empresa da nota externa ELETRO SHOPPING
And Eu clico no icone pesquisar produto da venda externa
And Eu informo o codigo pai do produto 215275 da venda externa
And Eu clico no botao Pesquisar da venda externa
And Eu seleciono o produto 215275 para garantia avulsa venda externa
And Eu seleciono uma garantia avulsa GARANTIA MAIOR TV LCD - 1 ANO
And Eu clico no botao Inserir Garantia
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Mastercard

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-41 no relatorio
