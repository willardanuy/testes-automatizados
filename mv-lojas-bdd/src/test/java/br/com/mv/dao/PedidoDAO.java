package br.com.mv.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mv.jdbc.Conexao;
import br.com.mv.model.NotaFiscal;
import br.com.mv.model.Pedido;
import br.com.mv.utils.Utils;

public class PedidoDAO {

	Connection connection;
	
	private static final String PATH_ARQUIVO = System.getProperty("user.dir") + "\\src\\test\\resources\\sql\\";
	
	public void executarScriptReset(String nomScript) throws IOException {
		
		connection = new Conexao().getConexao();
		
		String sql = new Utils().lerArquivo(PATH_ARQUIVO + nomScript);
		
		System.out.println(sql);
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.executeQuery();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public double buscarValorBasePlusJuros(String codNroLoja, String nroPedido) {
		
		connection = new Conexao().getConexao();
		
		String sql = "select decode( p.nro_tipo_Venda,76, ((i.vr_unitario_produto * i.fator_prestacao) * p.qtde_parcelas) - i.vr_unitario_produto, i.vr_faturamento_produto - i.vr_unitario_produto) base_plus_juros"
				+ " from mv_item_pedido_produto i, mv_pedido p"
				+ " where p.nro_loja=i.nro_loja"
				+ " and p.nro_pedido=i.nro_pedido"
				+ " and p.nro_loja= (select nro_loja from mv_loja where cod_nro_loja = " + codNroLoja + ")"
				+ " and p.nro_pedido= " + nroPedido;
						
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			double basePlusJuros = 0;
			
			
			while (rs.next()) {
				basePlusJuros = rs.getDouble("base_plus_juros");
				System.out.println("basePlusJuros: " + basePlusJuros);
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
			return basePlusJuros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}			
	}
	
	public double buscarPercentualPlusVendFinan(String codNroLoja, String nroVendedor) {
		
		connection = new Conexao().getConexao();
		
		String sql = "SELECT percentual_plus_vend_financ FROM  MV_PERCENTUAL_PLUS_VENDEDOR where NRO_VENDEDOR = " + nroVendedor + " and nro_loja= (select nro_loja from mv_loja where cod_nro_loja = " + codNroLoja + ")";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			double percPlusVendFinan = 0;
			
			while (rs.next()) {
				percPlusVendFinan = rs.getDouble("percentual_plus_vend_financ");
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
			return percPlusVendFinan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}	
	}
	
}