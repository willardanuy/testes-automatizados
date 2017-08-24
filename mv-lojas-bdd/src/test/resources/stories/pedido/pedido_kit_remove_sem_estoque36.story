Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento com cartão de crédito
KIT: 1044
Produto 1 (158488): permite venda avulsa -> Permite remover sem estoque -> Possui Estoque
Produto 2 (158486): não permite venda avulsa -> Não permite remover sem estoque -> Não possui Estoque
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido com KIT e empenho em DEPOSITO/NORMAL pagamento com cartão de crédito
Meta:
@tag component:Regressão - RELOH
@context PEDIDOS
@base RELOH
@grupoInstancias Pedidos
@issue rgs-36
@rgs-36

Given Eu executo o script de reset pedido_kit_remove_sem_estoque_36.sql
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 53 - CARTAO DE CREDITO

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 158488
!-- Produto (158486) sem estoque
And Eu clico no botao Ok do modal
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu removo o produto 158488

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 158488
And Eu clico no botao Ok do modal
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu removo o produto 158486
!-- Desmembrar kit
And Eu clico no botao Sim do modal

And Eu clico no icone detalhes do produto 158488
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento F
And Eu seleciono a 1 ª forma de pagamento Cartao Mastercard

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @rgs-36 no relatorio
