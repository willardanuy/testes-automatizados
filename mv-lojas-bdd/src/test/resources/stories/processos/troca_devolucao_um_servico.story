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
@issue trkdev-03
@trkdev-03

Given Eu acesso a instancia http://10.30.232.20:8080
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA
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
!-- And Eu salvo o pedido do teste @smk-06 no relatorio

Scenario: Efetua o recebimento do pedido
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-03
@trkdev-03

Given Eu acesso o pdv web http://10.30.232.19:8080
When Eu faco login no pdv web 110 na loja 1002 com usuario 7380 e senha 1
And Eu acesso o pdv menu Pedido
And No pdv eu pesquiso o pedido
And No pdv eu clico no botao receber pedido
And No pdv eu preencho os valores
And No pdv eu clico no botao Emitir Cupom
Then No pdv eu valido se o pedido foi recebido

Scenario: Elaboração de Pré-recibo
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-03
@trkdev-03

Given Eu acesso a instancia http://10.30.232.80:8080
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Troca/Devolução > Pré-Recibos
And Eu clico no botao novo Pré-recibo

!-- Pesquisando pedido e definindo quais produtos e serviços serao trocados/devolvidos
And Eu informo o numero do pedido
And Eu seleciono a empresa 18 - LOJAS SALFER S/A. - MVSH
And Eu informo a loja 1002
And Eu seleciono o processo Troca
And Eu clico no botao pesquisar

!-- Remove um produto da solicitacao de troca
And Eu seleciono o servico item SEGURANCA MOVEL 02
And Eu clico no botao Remover Servico da solicitacao

And Eu clico no botao Ok da tela de pre-recibo

!-- Informando Motivo para Serviços
And Eu seleciono o servico item ANTIVIRUS MOBILE HERO
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu clico no botao Salvar solicitacao

!-- Pesquisar pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o status 2 - AG. APROVACAO SERVICOS do pre-recibo
And Eu pesquiso o pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o pre-recibo
And Eu clico no botao Editar pre-recibo

!-- Aprovando Serviços
And Eu seleciono servico 297315 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

!-- Concluir Pré-recibo
And Eu clico no botao Ok para concluir pre-recibo