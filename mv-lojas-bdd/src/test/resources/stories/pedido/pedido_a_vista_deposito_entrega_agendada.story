Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista empenhado em depósito e entrega agendada
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista empenhado em depósito e entrega agendada
Meta:
@tag component:Smoke testing - RELOH
@context SMOKE_TESTING
@base RELOH
@grupoInstancias Pedidos
@issue smk-02
@smk-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 139756
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

!-- And Eu pesquiso e seleciono o produto 139756

And Eu clico no icone detalhes do produto 139756
And Eu seleciono o local de empenho DEPOSITO
And Eu seleciono a opcao de entrega AGENDADA
And Eu clico no botao Agendada
And Eu seleciono uma data disponivel
And Eu clico no botao Reservar

And Eu clico na aba Serviços
!-- And Eu removo o servico 163594

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @smk-02 no relatorio
