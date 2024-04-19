package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	public Usuarios selecionarUsuario(Usuarios usuario) {
		String read2 = "select * from usuarios where email = ? and senha = ?";
		DAO dao = new DAO();
		System.out.println(" 4selecionarUsuario=> "+usuario.getEmail()+" " +usuario.getSenha());
		try {
			Connection conexao = dao.conectar();
			PreparedStatement preparedStatement = conexao.prepareStatement(read2);
			preparedStatement.setString(1, usuario.getEmail());
			preparedStatement.setString(2, usuario.getSenha());
			ResultSet rs = preparedStatement.executeQuery();
			usuario.setEmail(null);
			usuario.setSenha(null);
			while (rs.next()) {
				// Setar as variaveis JavaBeans
				usuario.setEmail(rs.getString(1));
				usuario.setSenha(rs.getString(2));
				System.out.println("entrou while");
			}
			
			conexao.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;

	}
}
