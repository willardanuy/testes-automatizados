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
@context PROCESSOS
@base MVSH
@issue trkdev-05
@trkdev-05

Given Eu acesso a instancia http://10.30.232.20:8080
When Eu faco login na loja 1002 com usuario 49212 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 711
And Eu clico no icone detalhes do produto 711
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor 
!-- And Eu salvo o pedido do teste @smk-06 no relatorio

Scenario: Efetua o recebimento do pedido
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-05
@trkdev-05

Given Eu acesso o pdv web http://10.30.232.19:8080
When Eu faco login no pdv web 110 na loja 1002 com usuario 49212 e senha 1
And Eu acesso o pdv menu Pedido
And No pdv eu pesquiso o pedido
And No pdv eu clico no botao receber pedido
And No pdv eu preencho os valores
And No pdv eu clico no botao Emitir Cupom
Then No pdv eu valido se o pedido foi recebido

Scenario: Controle de Faturamento PDV 
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-05
@trkdev-05

Given Eu acesso a instancia http://10.30.232.80:8080
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Controles > Faturamento Pdv
And Eu informo o filtro numero do pedido controle de faturamento
And Eu clico no botao pesquisar controle de faturamento
And Eu seleciono o controle de faturamento
And Eu clico no botao Faturar controle de faturamento

Scenario: Elaboração de Pré-recibo
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-05
@trkdev-05

Given Eu acesso a instancia http://10.30.232.80:8080
-- And Eu adiciono o tipo de venda 1 para regra 8 de trocadevolucao
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Troca/Devolução > Pré-Recibos
And Eu clico no botao novo Pré-recibo

!-- Pesquisando pedido e definindo quais produtos e serviços serao trocados/devolvidos
And Eu informo o numero do pedido
And Eu seleciono a empresa 18 - LOJAS SALFER S/A. - MVSH
And Eu informo a loja 1002
And Eu seleciono o processo Devolucao
And Eu clico no botao pesquisar

!-- Valida mensagem: Não é permitida a devolução para o tipo de venda: 'A Vista'.
And Eu valido a regra 8
And Eu removo o tipo de venda 1 da regra 8