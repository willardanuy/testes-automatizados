Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com DEPOSITO/RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-05
@rgs-05

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 208974
And Eu clico no icone detalhes do produto 208974
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega RETIRADA OUTRA LOJA COM RESERVA DEPOSITO
And Eu informo a flag entrega como NÃO
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 291

And Eu clico no produto 208974
And Eu clico na aba Garantia
!-- And Eu removo a garantia 192434 do produto 208974
And Eu removo a garantia 144765 do produto 208974
And Eu informo o usuario 6699 e senha 1 para validar exclusao
!-- And Eu clico no botao Adicionar Garantia
!-- And Eu seleciono a garantia 192434

And Eu clico na aba Serviços
!-- And Eu altero a quantidade do servico 163594 para 2

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-05 no relatorio
