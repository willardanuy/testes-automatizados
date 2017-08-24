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
@issue trkdev-04
@trkdev-04

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

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 287377
And Eu clico no icone detalhes do produto 287377
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
@issue trkdev-04
@trkdev-04

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
@issue trkdev-04
@trkdev-04

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
@issue trkdev-04
@trkdev-04

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
!-- And Eu seleciono o produto item 39547
!-- And Eu clico no botao Remover Produto da solicitacao

And Eu clico no botao Ok da tela de pre-recibo

!-- Informando Motivo para Produtos
And Eu seleciono o produto item 1
And Eu clico no botao Motivo Produto
And Eu informo o motivo 4818 - DEFEITO para o produto selecionado
And Eu informo uma observacao OBS MOTIVO para o produto selecionado
And Eu clico no botao Concluir vinculo motivo

And Eu seleciono o produto item 2
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

And Eu seleciono o servico item GARANTIA MAIOR TV LCD - 2 ANOS.
And Eu clico no botao Motivo Servico
And Eu informo o motivo 3 - SERVICO NAO UTILIZADO para o servico selecionado
And Eu informo uma observacao OBS MOTIVO para o servico selecionado
And Eu clico no botao Concluir aprovacao de servico

And Eu seleciono o servico item AJUSTE DE PREÇO (LINHA VIDEO)
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
And Eu seleciono produto 287435 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de produto
And Eu seleciono a Etapa APROVAÇÃO GERENCIAL OU AUTOMÁTICA pendente aprovacao
And Eu informo uma observacao para a Etapa APROVAÇÃO GERENCIAL OU AUTOMÁTICA
And Eu clico no botao Aprovar produto

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

And Eu seleciono servico 144658 pendente aprovacao
And Eu clico no botao Fluxo Aprovacao de servico
And Eu informo uma observacao para aprovar o servico
And Eu clico no botao Aprovar servico

And Eu seleciono servico 215914 pendente aprovacao
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

!-- Controle produto 287377
And Eu clico no botao Pesquisar controle de devolucao
And Eu clico no botao Pesquisar nota fiscal
And Eu informo o numero da nota fiscal para consultar nota fiscal
And Eu limpo o campo loja de destino
And Eu seleciono o filtro somente notas Processado
And Eu clico no botao Pesquisar nota fiscal consulta
And Eu seleciono a nota fiscal avulsa
And Eu clico no botao Pesquisar

And Eu seleciono o item devolvido 287377
And Eu clico no botao Editar
And Eu seleciono o status do controle de devolucao Processado
And Eu informo uma observacao do controle de devolucao
And Eu clico no botao Salvar controle de devolucao
And Eu clico no botao Autorizar Emissao Recibo

!-- Controle produto 711

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
And Eu clico no botao Autorizar Emissao Recibo

!-- IMPRIMIR COMPROVANTE DE PRE-RECIBO NO PDV PARA LIBERAR O CREDITO

Scenario: Elaborar um pedido a vista com rebibo de troca do pedido anterior
Meta:
@tag component:Regressão - MVSH
@context PROCESSOS
@base MVSH
@issue trkdev-04
@trkdev-04

Given Eu acesso a instancia http://10.30.232.20:8080
When Eu faco login na loja 1002 com usuario 49212 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 287377
And Eu clico no icone detalhes do produto 287377
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 711
And Eu clico no icone detalhes do produto 711
And Eu seleciono o local de empenho LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Recibo de Troca
And Eu clico no botao pesquisar Recibo de Troca
And Eu informo o pedido com credito
And Eu informo o codigo da loja do pedido com credito
And Eu informo a empresa do pedido com credito
And Eu clico no botao Verificar Credito
And Eu clico no botao Ok do modal
And Eu clico no botao Utilizar Credito

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor