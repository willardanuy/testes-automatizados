Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM EMPENHO DEPOSITO
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/RETIRADA OUTRA LOJA COM EMPENHO DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-08
@rgs-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 188774
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 188774
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286

And Eu clico na aba Garantia
And Eu removo a garantia 140358 do produto 188774
And Eu valido se a garantia 149535 foi adicionada para o produto 188774
And Eu clico na aba Produto
And Eu clico no produto 188774
And Eu clico na aba Garantia
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 140358

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu clico em adicionar servico
And Eu adiciono o servico 103519

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 188774
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 188774
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu clico no botao Ok do modal

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
@issue rgs-08
@rgs-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Reabertura

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 16376
And Eu clico no icone detalhes do produto 16376
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286

And Eu clico na aba Garantia
And Eu valido se a garantia 140358 foi adicionada para o produto 188774
And Eu valido se a garantia 136711 foi adicionada para o produto 16376

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu valido se o servico 103519 ja foi adicionado

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 188774
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 188774
And Eu clico no botao Liberar
And Eu informo a observacao .. Liberar empenho em outra loja da liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 16376
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 16376
And Eu clico no botao Liberar
And Eu informo a observacao .. Liberar empenho em outra loja da liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu removo todas as planilhas
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-08 no relatorio
