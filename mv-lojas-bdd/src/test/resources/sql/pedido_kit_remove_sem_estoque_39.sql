DECLARE
  
BEGIN
	
update mv_item_kit set qtde_produto = 1, ind_permite_venda_avulsa = 1, flag_item_principal = 'N', ind_permite_promocao_item = 1, ind_remove_sem_estoque = 'S' where nro_produto = 87607 and nro_kit = 414;
update mv_item_kit set qtde_produto = 1, ind_permite_venda_avulsa = 0, flag_item_principal = 'N', ind_permite_promocao_item = 1, ind_remove_sem_estoque = 'N' where nro_produto = 93417 and nro_kit = 414;
update mv_item_kit set qtde_produto = 1, ind_permite_venda_avulsa = 0, flag_item_principal = 'N', ind_permite_promocao_item = 1, ind_remove_sem_estoque = 'S' where nro_produto = 135156 and nro_kit = 414;

update mv_estoque_produto set qtde_estoque = 0 where nro_produto = 135156 and nro_loja = 1101 and nro_grupo_estoque = 1;
update mv_estoque_produto set qtde_estoque = 1000 where nro_produto = 87607 and nro_loja = 1101 and nro_grupo_estoque = 1;
update mv_estoque_produto set qtde_estoque = 1000 where nro_produto = 93417 and nro_loja = 1101 and nro_grupo_estoque = 1;

update mv_info_estoque set flag_saida_estoque = 4 where nro_produto in (87607, 135156, 93417) and nro_loja = 1101;

END;