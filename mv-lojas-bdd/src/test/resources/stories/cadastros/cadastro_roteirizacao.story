Narrative:
Como um usuário adm da loja
Eu quero cadastrar um roteiro
De modo que um pedido possa utilizar o roteiro criado

Scenario: Cadastra um roteiro
Meta:
@tag component:Regressao - RELOH
@context REGRESSAO
@base RELOH
@issue cad-01
@cad-01

Given Eu acesso a instancia http://10.30.232.81:8080
When Eu faco login na loja 291 com usuario 6699 e senha 1
And Eu acesso o menu Cadastros Adm > Roteirização > Roteiros
And Eu removo o roteiro

And Eu clico no botao novo roteiro
And Eu informo o codigo loja 221 do roteiro
And Eu informo o uf MG do roteiro
And Eu informo a cidade IBIRITE do roteiro
And Eu informo no roteiro a rota A
And Eu informo a sequencia 1 do roteiro
And Eu informo a data de intervalo 01/01/2012 - 25/09/2020 do roteiro
And Eu informo a quantidade dias 7 do roteiro para entrega
And Eu informo a origem LOJA do roteiro
And Eu informo no roteiro a empresa base 5 - RN COMERCIO VAREJISTA S.A RELOH
And Eu clico no filtro adicional do roteiro
!-- And Eu clico no filtro todos os bairros do roteiro
And Eu informo o bairro PIRATININGA do roteiro
And Eu clico no salvar roteiro

Then Eu valido mensagem de sucesso do roteiro

Scenario: Cadastra uma rota
Meta:
@tag component:Regressao - RELOH
@context REGRESSAO
@base RELOH
@issue cad-01
@cad-01

Given Eu acesso a instancia http://10.30.232.81:8080
When Eu faco login na loja 291 com usuario 6699 e senha 1
And Eu acesso o menu Cadastros Adm > Roteirização > Rotas
And Eu removo a rota 1Z

And Eu clico no botao nova rota
And Eu informo a base 9221
And Eu informo a rota 1Z
And Eu informo o nro loja de refaturamento 291
And Eu informo o nro loja de abastecimento 47
And Eu informo a empresa base 5 - RN COMERCIO VAREJISTA S.A RELOH

Scenario: Cadastra uma sequencia de empenho
Meta:
@tag component:Regressao - RELOH
@context REGRESSAO
@base RELOH
@issue cad-01

Given Eu acesso a instancia http://10.30.232.81:8080
When Eu faco login na loja 291 com usuario 6699 e senha 1
And Eu acesso o menu Cadastros Adm > Roteirização > Sequência de Empenho
And Eu removo a sequencia de empenho

And Eu clico no botao nova sequencia de empenho
And Eu informo a base 9221
And Eu informo a sequencia 1 da sequencia de empenho
And Eu informo o nro loja de sequencia de empenho 47
And Eu informo na tela sequencia de empenho a empresa base 5
And Eu informo a data inicio da validade da sequencia de empenho 01/01/2010
And Eu informo a data fim da validade da sequencia de empenho 25/09/2020
And Eu clico salvar sequencia de empenho

Then Eu valido mensagem de sucesso da sequencia de empenho