Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com cartão de crédito
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com cartão de crédito
Meta:
@tag component:Smoke testing - RELOH
@context SMOKE_TESTING
@base RELOH
@grupoInstancias Pedidos
@issue smk-08
@smk-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 53 - CARTAO DE CREDITO

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 214954
And Eu clico no icone detalhes do produto 214954
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu valido se o servico 104141 ja foi adicionado

And Eu informo um valor de entrada de 50,00

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento E
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron

And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento F
And Eu seleciono a 2 ª forma de pagamento BANESCARD CREDITO

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @smk-08 no relatorio
