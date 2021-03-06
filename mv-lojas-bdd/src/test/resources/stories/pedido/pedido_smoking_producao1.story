Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista de um servico
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista de um servico
Meta:
@tag component:Smoke testing Producao - RELOH
@context SMOKE_TESTING
@base RELOH
@issue prd-smk-01
@prd-smk-01

Given Eu acesso a instancia padraoProducao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico na aba Serviços
And Eu clico em adicionar servico
And Eu adiciono o servico 103513
And Eu clico no botao Salvar
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
!-- And Eu salvo o pedido do teste @smk-01 no relatorio


Scenario: Elaborar um pedido a vista de um servico
Meta:
@tag component:Smoke testing Producao - RELOH
@context SMOKE_TESTING
@base RELOH
@issue prd-smk-01
@prd-smk-01

Given Eu acesso a instancia padraoProducao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu acesso o menu Consultar > Pedido
And Eu consulto o pedido
And Eu clico no botao Cancelar pedido

Scenario: Elaborar um pedido a vista de um servico
Meta:
@tag component:Smoke testing Producao - RELOH
@context SMOKE_TESTING
@base RELOH
@issue prd-smk-02
@prd-smk-02

Given Eu acesso a instancia padraoProducao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico na aba Serviços
And Eu clico em adicionar servico
And Eu adiciono o servico 103513

And Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Cancelar pedido
