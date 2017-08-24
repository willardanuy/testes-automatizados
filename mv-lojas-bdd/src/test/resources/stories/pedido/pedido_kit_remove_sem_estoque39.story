Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento a vista
KIT: 414
Produto 1 (135156) -> Não permita a venda avulsa -> Permite Remover Sem Estoque -> Está Sem estoque
Produto 2 (8776) -> Permite venda avulsa -> Permite Remover Sem Estoque -> Possui Estoque
Produto 3 (93417) -> Não permita a venda avulsa
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento a vista
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-39
@rgs-39

Given Eu executo o script de reset pedido_kit_remove_sem_estoque_39.sql
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 8776
!-- Produto (158486) sem estoque
And Eu clico no botao Ok do modal
And Eu clico no botao Selecionar Produto

And Eu removo o produto 135155
!-- Remove todos

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 8776
!-- Produto (158486) sem estoque
And Eu clico no botao Ok do modal
And Eu clico no botao Selecionar Produto

And Eu removo o produto 12905
!-- Remove todos

!-- Coloca estoque em todos os produtos
And Eu executo o script de reset pedido_kit_remove_sem_estoque_39_1.sql

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 8776
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 8776
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Cartao Visa Electron

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-39 no relatorio
