Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista
Meta:
@tag component:Smoke testing - RELOH
@context SMOKE_TESTING
@base RELOH
@grupoInstancias Pedidos
@issue smk-06
@smk-06

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso o produto 139550
And Eu deixo o produto sem promocao
And Eu clico no botao Selecionar Produto

And Eu clico no icone detalhes do produto 139550

And Eu informo o numero de serie 0001
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico no produto 139550
And Eu clico na aba Garantia
And Eu removo a garantia 143191 do produto 139550
And Eu informo o usuario 6699 e senha 1 para validar exclusao
And Eu clico no botao Adicionar Garantia
And Eu seleciono a garantia 143191

!-- And Eu clico na aba Serviços
!-- And Eu removo o servico 163594

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @smk-06 no relatorio