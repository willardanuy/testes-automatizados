Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com cartão MVShop
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com cartão MVShop
Meta:
@tag component:Smoke testing - RELOH
@context SMOKE_TESTING
@base RELOH
@grupoInstancias Pedidos
@issue smk-07
@smk-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'
And Eu seleciono o tipo de venda 70 - CARTAO MVSHOP
And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 219757
And Eu seleciono a tabela 65 - TABELA 65 (PLU$) para o produto 219757

And Eu clico no icone detalhes do produto 219757
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA CLIENTE
And Eu informo uma data e um turno disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594
And Eu removo o servico 187814
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu valido se o servico 104141 ja foi adicionado

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento MV Shop 1.Compra

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 10 - Ag. Liberações
And Eu salvo o pedido do teste @smk-07 no relatorio
