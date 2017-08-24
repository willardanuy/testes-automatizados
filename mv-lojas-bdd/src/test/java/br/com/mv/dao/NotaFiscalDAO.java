package br.com.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mv.jdbc.Conexao;
import br.com.mv.model.NotaFiscal;

public class NotaFiscalDAO {

Connection connection;
	
	/**
	 * Pega as notas fiscais necessárias na hora de efetuar a troca ou devolução de um produto/serviço/pedido
	 * @param nroLoja, int com o número da loja
	 * @param nroPedido, int com o número do pedido
	 * @param nroTiposNf, String com todos os tipos de nf separados por ','. Ex.: ("1,10")
	 * @return
	 */
	public NotaFiscal getNotaFiscal(String nroLoja, String nroPedido, String tiposNf) {
		
		connection = new Conexao().getConexao();
		
		String sql = " SELECT NF.NRO_TIPO_NF, "
					       + " NF.NRO_CUPOM, "
					       + " NF.COD_TIPO_DOCTO, "
					       + " NF.NRO_NF, "
					       + " NF.SERIE_NF, "
					       + " NF.NRO_LOJA, "
					       + " L.COD_NRO_LOJA, "
					       + " NF.NRO_LOJA_DESTINO " 
					  + " FROM MV_PEDIDO PED "
					       + " INNER JOIN MV_NF NF ON NF.NRO_LOJA_PEDIDO = PED.NRO_LOJA "
					              + " AND NF.NRO_PEDIDO = PED.NRO_PEDIDO "
					       + " INNER JOIN MV_LOJA L ON NF.NRO_LOJA = L.NRO_LOJA "
					 + " WHERE PED.NRO_PEDIDO = " + nroPedido
					   + " AND L.COD_NRO_LOJA = " + nroLoja
					   + " AND NF.NRO_TIPO_NF IN (" + tiposNf + ")";
		
		//System.out.println(sql);
		
		try {
			NotaFiscal notaFiscal = new NotaFiscal();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				notaFiscal.setNroTipoNf(rs.getInt("NRO_TIPO_NF"));
				notaFiscal.setNroCupom(rs.getInt("NRO_CUPOM"));
				notaFiscal.setCodTipoDocto(rs.getString("COD_TIPO_DOCTO"));
				notaFiscal.setNroNf(rs.getInt("NRO_NF"));
				notaFiscal.setSerieNf(rs.getString("SERIE_NF"));
				notaFiscal.setNroLoja(rs.getInt("NRO_LOJA"));
				notaFiscal.setCodNroLoja(rs.getInt("COD_NRO_LOJA"));
				notaFiscal.setNroLojaDestino(rs.getInt("NRO_LOJA_DESTINO"));
				
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
			return notaFiscal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		
	}
	/*
	public List<ProdutoNf> getItensNf(int nroNf, int nroLoja) {
		
		connection = new Conexao().getConexao();
		
		String sql = "SELECT " 
						  + " nf.nro_nf, "
						  + " nf.nro_loja, "
						  + " inf.nro_produto, "
						  + " p.cod_nro_produto, "
						  + " p.desc_produto "
						+ " FROM " 
						  + " mv_nf nf "
						  + " INNER JOIN mv_item_nf inf ON nf.nro_seq_nf = inf.nro_seq_nf "
						    + " AND nf.nro_loja = inf.nro_loja "
						  + " INNER JOIN mv_produto p ON inf.nro_produto = p.nro_produto "
						+ " WHERE " 
						  + " nf.nro_nf = " + nroNf + " and nf.nro_loja = " + nroLoja;
		
		try {
			List<ProdutoNf> itensNf = new ArrayList<ProdutoNf>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				ProdutoNf prodNf = new ProdutoNf();
				prodNf.setNroNf(rs.getInt("nro_nf"));
				prodNf.setNroLoja(rs.getInt("nro_loja"));
				prodNf.setNroProduto(rs.getInt("nro_produto"));
				prodNf.setCodNroProduto(rs.getInt("cod_nro_produto"));
				prodNf.setDescProduto(rs.getString("desc_produto"));
				itensNf.add(prodNf);
			}
			
			return itensNf;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}*/
	
	public void aprovarNota(int nroLoja, int nroPedido, int nroTipoNf) {
		
		connection = new Conexao().getConexao();
		
		String sql = "UPDATE mv_nf set flag_situacao_docto_nf = 'A' WHERE nro_loja = ? AND nro_pedido = ? and nro_tipo_nf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, nroLoja);
			stmt.setInt(2, nroPedido);
			stmt.setInt(3, nroTipoNf);
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}
	
	public void aprovarNFe(int nroLoja, int nroNF) {
		
		connection = new Conexao().getConexao();
		
		String sql = "UPDATE MV_NFE SET STATUS_RE = 'A', MOTIVO = 'Autorizado o uso da NF-e' " + 
					 "WHERE NRO_SEQ_NF = (SELECT NRO_SEQ_NF FROM MV_NF WHERE NRO_NF = ? AND NRO_LOJA = ?)";
		
		String sql2 = "UPDATE MV_NF SET FLAG_SITUACAO_DOCTO_NF = 'A' " +
					  "WHERE NRO_NF = ? AND NRO_LOJA = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			
			stmt.setInt(1, nroNF);
			stmt.setInt(2, nroLoja);
			stmt.executeQuery();
			stmt.close();
			
			stmt2.setInt(1, nroNF);
			stmt2.setInt(2, nroLoja);
			stmt2.executeQuery();
			stmt2.close();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public NotaFiscal getNotaFiscalTransferencia(int nroLoja, int nroPedido) {
		
		connection = new Conexao().getConexao();
		
		String sql = "SELECT NF.NRO_NF " +
					 "FROM   MV_CONTROLE_FATURAMENTO CF " +
					 "		 INNER JOIN MV_NF NF ON NF.NRO_SEQ_NF = CF.NRO_SEQ_NF " +
					 "WHERE  CF.NRO_PEDIDO = " + nroPedido + " AND CF.NRO_LOJA_PEDIDO = " + nroLoja;
		
		try {
			NotaFiscal notaFiscal = new NotaFiscal();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				notaFiscal.setNroNf(rs.getInt("NRO_NF"));
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
			return notaFiscal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	public List<NotaFiscal> getNotaFiscalPedidoReverso(int nroPreReciboReverso) {
		connection = new Conexao().getConexao();
		
		String sql = "SELECT  NF.NRO_NF " +
					 "FROM    MV_CONTROLE_FATURAMENTO CF " +
					 "        INNER JOIN MV_APROVACAO_REVERSO AR on AR.SEQ_CONTROLE_FATURAMENTO = CF.SEQ_CONTROLE_FATURAMENTO " +
					 "        INNER JOIN MV_NF NF on NF.NRO_SEQ_NF = CF.NRO_SEQ_NF " +
					 "WHERE   AR.NRO_PRE_RECIBO_REVERSO = " + nroPreReciboReverso;
		
		try {
			List<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				NotaFiscal nfs = new NotaFiscal();
				nfs.setNroNf(rs.getInt("NRO_NF"));
				notasFiscais.add(nfs);
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
			return notasFiscais;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	/*
	public void associarCargaControleFaturamento(int nroPedido, int nroLojaPedido, int nroCargaVeiculo) {
		connection = new Conexao().getConexao();
				
		String sql = "select seq_controle_faturamento from mv_controle_faturamento where nro_pedido = " + nroPedido + " and nro_loja_pedido = " + nroLojaPedido;
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			int seqControleFaturamento = 0;
			
			CargaDAO cargaVeiculoDAO = new CargaDAO();
			
			while (rs.next()) {
				seqControleFaturamento = rs.getInt("seq_controle_faturamento");
				
				Carga cargaVeiculo = cargaVeiculoDAO.getCargaVeiculo(nroCargaVeiculo);
				
				String sql1 = "update mv_controle_faturamento "
							+ "set 	NRO_FORNECEDOR_TRANSPORTADORA = " + cargaVeiculo.getNroTransportador() + ", "
							+ "		NRO_CARGA_VEICULO = " + cargaVeiculo.getNroCargaVeiculo() + ", "
							+ "		PLACA_VEICULO = '" + cargaVeiculo.getPlacaVeiculo() + "', "
							+ "		PLACA_VEICULO_UF = '" + cargaVeiculo.getPlacaVeiculoUF() + "' " +
						 	  "where SEQ_CONTROLE_FATURAMENTO = " + seqControleFaturamento;
				
				PreparedStatement stmt1 = connection.prepareStatement(sql1);
				stmt1.executeQuery();
				stmt1.close();
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}*/
}