package br.com.mv.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import br.com.mv.pages.HomePage;

/**
 * Conexao
 * 
 */
public class Conexao {
	
	public Connection getConexao() {
		try {
			//return DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.18:1521:RELOH", "mv","mv");
			//return DriverManager.getConnection("jdbc:oracle:thin:@exa01.maquinadevendas.corp:1521/RELOH", "mv", "mv");
			
			Map<String, String> metadata = HomePage.getTags();
			
			String base = "RELOH";
			
			if (!metadata.get("base").isEmpty()) {
				base = metadata.get("base");
			}
	    
			return DriverManager.getConnection("jdbc:oracle:thin:@exa01.maquinadevendas.corp:1521/" + base, "mv", "mv");
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}