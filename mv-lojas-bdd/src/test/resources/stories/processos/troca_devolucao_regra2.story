Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um processo de troca/devolução
De modo que o pré-recibo esteja aprovado ao final do processo

!-- *******************
!--   RELOH
!-- *******************
Scenario: Elaborar um pedido a vista
Meta:
@tag component:Smoke testing - RELOH
@context PROCESSOS
@base RELOH
@issue trkdev-01
@trkdev-01

Given Eu acesso a instancia http://10.41.0.101:8080
When Eu faco login na loja 4010 com usuario 7380 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 223892
And Eu clico no icone detalhes do produto 223892
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
And Eu valido o status do pedido 30 - Ag. Recebimento
!-- And Eu salvo o pedido do teste @smk-06 no relatorio

Scenario: Efetua o recebimento do pedido
Meta:
@tag component:Regressão - RELOH
@context PROCESSOS
@base RELOH
@issue trkdev-01
@trkdev-01

Given Eu acesso o pdv web http://10.30.232.15:8080
When Eu faco login no pdv web 110 na loja 4010 com usuario 7380 e senha 1
And Eu acesso o pdv menu Pedido
And No pdv eu pesquiso o pedido
And No pdv eu clico no botao receber pedido
And No pdv eu preencho os valores
And No pdv eu clico no botao Emitir Cupom
Then No pdv eu valido se o pedido foi recebido

Scenario: Elaboração de Pré-recibo
Meta:
@tag component:Regressão - RELOH
@context PROCESSOS
@base RELOH
@issue trkdev-01
@trkdev-01

Given Eu acesso a instancia http://10.30.232.81:8080
When Eu faco login na loja 4010 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Troca/Devolução > Pré-Recibos
And Eu clico no botao novo Pré-recibo

!-- Pesquisando pedido e definindo quais produtos e serviços serao trocados/devolvidos
And Eu informo o numero do pedido
And Eu seleciono a empresa 5 - RN COMERCIO VAREJISTA S.A - RELOH EXA
And Eu informo a loja 4010
And Eu seleciono o processo Troca
And Eu clico no botao pesquisar
And Eu clico no botao Ok da tela de pre-recibo

!-- Informando Motivo para Produtos
And Eu seleciono o produto item 1
And Eu clico no botao Motivo Produto
And Eu informo o motivo 409 - TESTE AUT. - LIB_REC_DEV_S_NF_DEV_CONF - TROCA para o produto selecionado
And Eu informo uma observacao OBS MOTIVO para o produto selecionado
And Eu clico no botao Concluir vinculo motivo

!-- Informando Motivo para Serviços
And Eu seleciono o servico item AJUSTE DE PREÇO (LINHA AUDIO)
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu seleciono o servico item SEG CAMINHAO DA SORTE.
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu clico no botao Salvar solicitacao

!-- Pesquisar pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o status 1 - AG. APROVACAO PRODUTOS do pre-recibo
And Eu pesquiso o pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o pre-recibo
And Eu clico no botao Editar pre-recibo

!-- Aprovando Produtos
And Eu seleciono produto 223893 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de produto
And Eu seleciono a Etapa REGRA - LIB_REC_DEV_S_NF_DEV_CONF pendente aprovacao
And Eu informo uma observacao para a Etapa REGRA - LIB_REC_DEV_S_NF_DEV_CONF
And Eu clico no botao Aprovar produto

!-- Aprovando Serviços
And Eu seleciono servico 163594 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

And Eu seleciono servico 215916 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

!-- Concluir Pré-recibo
And Eu clico no botao Ok para concluir pre-recibo

!-- Emissão NF Avulsa
And Eu acesso o menu Faturamento > Emissão NF Avulsa
And Eu seleciono a operacao de Entrada da nota fiscal
And Eu seleciono o tipo de nota fiscal 22
And Eu seleciono o grupo de estoque origem 1 - Loja
And Eu clico no botao Informar Parametros
And Eu informo o numero da nota tipo 5
And Eu informo a empresa da nota tipo 5
And Eu informo o codigo loja da nota tipo 5
And Eu informo o numero da serie da nota tipo 5
And Eu clico no botao Pesquisar nota fiscal tipo 5
And Eu seleciono o cupom fiscal
And Eu clico no botao Concluir parametros
And Eu clico no botao Concluir emissao nf avulsa tipo 22

!-- Controle de Devolução de Produtos
And Eu acesso o menu Faturamento > Controles > Devolução de Produtos
And Eu clico no botao Pesquisar controle de devolucao
And Eu clico no botao Pesquisar nota fiscal
And Eu informo o numero da nota fiscal para consultar nota fiscal
And Eu limpo o campo loja de destino
And Eu seleciono o filtro somente notas Processado
And Eu clico no botao Pesquisar
And Eu seleciono a nota fiscal avulsa
And Eu clico no botao Pesquisar
And Eu seleciono o item devolvido 223892
And Eu clico no botao Editar
And Eu seleciono o status do controle de devolucao Processado
And Eu informo uma observacao do controle de devolucao
And Eu clico no botao Salvar controle de devolucao


!-- *******************
!--   MVSH
!-- *******************

Scenario: Elaborar um pedido a vista
Meta:
@tag component:Smoke testing - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-01
@trkdev-01

Given Eu acesso a instancia http://10.41.0.86:8080
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
@issue trkdev-01
@trkdev-01

Given Eu acesso o pdv web http://10.30.232.19:8080
When Eu faco login no pdv web 110 na loja 1002 com usuario 7380 e senha 1
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
@issue trkdev-01
@trkdev-01

Given Eu acesso a instancia http://10.41.0.82:8080
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
@issue trkdev-01
@trkdev-01

Given Eu acesso a instancia http://10.41.0.82:8080
When Eu faco login na loja 1002 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Troca/Devolução > Pré-Recibos
And Eu clico no botao novo Pré-recibo

!-- Pesquisando pedido e definindo quais produtos e serviços serao trocados/devolvidos
And Eu informo o numero do pedido
And Eu seleciono a empresa 18 - LOJAS SALFER S/A. - MVSH
And Eu informo a loja 1002
And Eu seleciono o processo Troca
And Eu clico no botao pesquisar
And Eu clico no botao Ok da tela de pre-recibo

!-- Informando Motivo para Produtos
And Eu seleciono o produto item 1
And Eu clico no botao Motivo Produto
And Eu informo o motivo 4818 - DEFEITO para o produto selecionado
And Eu informo uma observacao OBS MOTIVO para o produto selecionado
And Eu clico no botao Concluir vinculo motivo

!-- Informando Motivo para Serviços
And Eu seleciono o servico item ROUBO E FURTO QUALIFICADO NOTEBOOK
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu seleciono o servico item MONTAGEM MOVEIS IGUANAFIX BASICO
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu seleciono o servico item SEGURANCA MOVEL 02
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu seleciono o servico item ANTIVIRUS MOBILE HERO
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu clico no botao Salvar solicitacao

!-- Pesquisar pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o status 1 - AG. APROVACAO PRODUTOS do pre-recibo
And Eu pesquiso o pre-recibo
And Eu clico no botao Pesquisar pre-recibo
And Eu seleciono o pre-recibo
And Eu clico no botao Editar pre-recibo

!-- Aprovando Produtos
And Eu seleciono produto 39547 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de produto
And Eu seleciono a Etapa APROVAÇÃO GERENCIAL OU AUTOMÁTICA pendente aprovacao
And Eu informo uma observacao para a Etapa APROVAÇÃO GERENCIAL OU AUTOMÁTICA
And Eu clico no botao Aprovar produto

!-- Aprovando Serviços
And Eu seleciono servico 195794 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

And Eu seleciono servico 301558 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

And Eu seleciono servico 301557 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

And Eu seleciono servico 297315 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

!-- Concluir Pré-recibo
And Eu clico no botao Ok para concluir pre-recibo

!-- Emissão NF Avulsa
And Eu acesso o menu Faturamento > Emissão NF Avulsa
And Eu seleciono a operacao de Entrada da nota fiscal
And Eu seleciono o tipo de nota fiscal 22
And Eu seleciono o grupo de estoque origem 1 - Loja
And Eu clico no botao Informar Parametros
And Eu informo o numero da nota tipo 10
And Eu informo a empresa da nota tipo 10
And Eu informo o codigo loja da nota tipo 10
And Eu informo o numero da serie da nota tipo 10
And Eu clico no botao Pesquisar nota fiscal tipo 10
And Eu seleciono o cupom fiscal
And Eu clico no botao Concluir parametros
And Eu clico no botao Concluir emissao nf avulsa tipo 22

!-- Controle de Devolução de Produtos
And Eu acesso o menu Faturamento > Controles > Devolução de Produtos
And Eu clico no botao Pesquisar controle de devolucao
And Eu clico no botao Pesquisar nota fiscal
And Eu informo o numero da nota fiscal para consultar nota fiscal
And Eu limpo o campo loja de destino
And Eu seleciono o filtro somente notas Processado
And Eu clico no botao Pesquisar nota fiscal consulta
And Eu seleciono a nota fiscal avulsa
And Eu clico no botao Pesquisar
And Eu seleciono o item devolvido 711
And Eu clico no botao Editar
And Eu seleciono o status do controle de devolucao Processado
And Eu informo uma observacao do controle de devolucao
And Eu clico no botao Salvar controle de devolucao