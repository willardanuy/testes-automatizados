Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento a vista
KIT: 1044
Produto 1 (158488) -> Não permita a venda avulsa -> Permite Remover Sem Estoque -> Possui Estoque
Produto 2 (158486) -> Permite venda avulsa -> Permite Remover Sem Estoque -> Está Sem estoque
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento a vista
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-37
@rgs-37

Given Eu executo o script de reset pedido_kit_remove_sem_estoque_37.sql
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 158488
!-- Produto (158486) sem estoque
And Eu clico no botao Ok do modal
And Eu clico no botao Selecionar Produto

And Eu removo o produto 158488
!-- Desmembra o kit e sobra o 158486
And Eu clico no botao Sim do modal

And Eu removo o produto 158486

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 158488
And Eu clico no botao Ok do modal
And Eu clico no botao Selecionar Produto

And Eu removo o produto 158486
!-- Sobra o produto (158488)

And Eu clico no icone detalhes do produto 158488
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-37 no relatorio
