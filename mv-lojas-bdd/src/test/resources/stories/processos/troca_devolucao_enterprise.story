Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um processo de troca/devolução de apenas um produto de um pedido com 2 produtos 
De modo que o pré-recibo esteja aprovado ao final do processo

!-- *******************
!--   MVSH
!-- *******************

Scenario: Elaborar um pedido a vista
Meta:
@tag component:Regressão - MVSH
@context REGRESSAO
@base MVSH
@issue trkdev-04
@trkdev-04

Given Eu acesso a instancia http://10.30.232.20:8080
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 711
And Eu clico no icone detalhes do produto 711
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 287377
And Eu clico no icone detalhes do produto 287377
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento CREDITO ENTERPRISE
And Eu clico no botao pesquisar Credito Enterprise
And Eu informo o pedido 24800790 com credito enterprise
And Eu informo o codigo da loja 188 do pedido com credito enterprise
And Eu informo a empresa SALFER do pedido com credito enteprise
And Eu clico no botao Verificar Credito enterprise
And Eu clico no botao Ok do modal credito enterprise
And Eu clico no botao Utilizar Credito enterprise

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 2 º tipo de pagamento V
And Eu seleciono a 2 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 23 - Ag. Liberação Pós Venda
!-- And Eu salvo o pedido do teste @smk-06 no relatorio