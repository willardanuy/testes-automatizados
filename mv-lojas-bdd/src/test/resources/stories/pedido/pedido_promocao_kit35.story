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
@issue rgs-35
@rgs-35

Given Eu executo o script de reset pedido_kit_com_promocao35.sql 
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 139756
And Eu deixo o produto sem promocao
And Eu clico no botao Kit
And Eu seleciono o kit 2300
And Eu seleciono a promocao de valor 1.000,00
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 139756
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu informo a flag entrega como SIM
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico na aba Serviços
And Eu clico em adicionar servico
And Eu adiciono o servico 209514
And Eu altero a quantidade do servico 209514 para 3
!-- And Eu removo o servico 163594
And Eu altero o valor unitario do servico 104141 para 27,00

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

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-35 no relatorio
