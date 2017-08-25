DECLARE
  
BEGIN
	
update mv_item_kit set qtde_produto = 1, ind_permite_venda_avulsa = 1, flag_item_principal = 'N', ind_permite_promocao_item = 1 where nro_produto in (139757) and nro_kit = 1935;
update mv_item_kit set qtde_produto = 1, ind_permite_venda_avulsa = 0, flag_item_principal = 'N', ind_permite_promocao_item = 1 where nro_produto in (139755,139765) and nro_kit = 1935;

END;