package br.com.mv.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mv.jdbc.Conexao;
import br.com.mv.utils.Utils;

public class PedidoDAO {

	Connection connection = new Conexao().getConexao();
	
	private static final String PATH_ARQUIVO = System.getProperty("user.dir") + "\\src\\test\\resources\\sql\\";
	
	public void executarScriptReset(String nomScript) throws IOException {
		
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
}