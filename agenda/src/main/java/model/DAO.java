package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	// parametro de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The Constant URL. */
	private static final String URL = "jdbc:mysql://localhost:3306/dbagenda?characterEncoding=utf-8";

	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "zeca";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// metodo de conexao
	public Connection conectar() {
		System.out.println("conectar");
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, user, password);
			return con;

		} catch (Exception e) {
			System.out.println("erro ao tentar conectar  " + e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	// crud create
	public void inserirContato(JavaBeans contato) {
		System.out.println("inserirContato");
		String create = "insert into contatos (nome, fone, email, endereco, estado, dataNiver) values(?, ?, ?, ?, ?, ?)";
		try {
			// abrir conexao
			Connection conexao = conectar();

			// preparar a query para execucao banco de dados
			PreparedStatement preparedStatement = conexao.prepareStatement(create);

			// substituir os parametos (?) pelo conteudo das variaveis da clase JavaBeans
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getFone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setString(4, contato.getEndereco());
			preparedStatement.setString(5, contato.getEstado());
			System.out.println(contato.getDataNiver());
			preparedStatement.setDate(6, new java.sql.Date(contato.getDataNiver().getTime()));

			// Executar a query
			preparedStatement.executeUpdate();

			// Encerrar Banco
			conexao.close();

		} catch (Exception e) {
			System.out.println("erro ao tentar executar o sql " + e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	// crud read
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JAvaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select idcon, nome, fone, email, endereco, estado, dataNiver from contatos order by nome";
		try {
			Connection conexao = conectar();
			PreparedStatement preparedStatement = conexao.prepareStatement(read);
			ResultSet rs = preparedStatement.executeQuery();

			// enquanto ouver contatos
			while (rs.next()) {

				// variaveis de apoio que recebem os dados do banco
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String endereco = rs.getString(5);
				String estado = rs.getString(6);
				Date dataNiver = rs.getDate(7);

				// populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email, endereco, estado, dataNiver));
			}
			conexao.close();
			return contatos;
		} catch (Exception e) {
			System.out.println("erro ao tentar executar o select " + e);
			return null;
		}
	}

	// CRUD UPDATE
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	// selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement preparedStatement = conexao.prepareStatement(read2);
			preparedStatement.setInt(1, contato.getIdcon());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// Setar as variaveis JavaBeans
				contato.setIdcon(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				contato.setEndereco(rs.getString(5));
				contato.setEstado(rs.getString(6));
				contato.setDataNiver(rs.getDate(7));

			}
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	// Editar contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?, fone=?, email=?, endereco=?, estado=?, dataNiver=? where idcon=?";
		try {
			Connection conexao = conectar();
			PreparedStatement preparedStatement = conexao.prepareStatement(create);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getFone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setString(4, contato.getEndereco());
			preparedStatement.setString(5, contato.getEstado());
			preparedStatement.setDate(6, new java.sql.Date(contato.getDataNiver().getTime()));
			preparedStatement.setInt(7, contato.getIdcon());
			preparedStatement.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	// CRUD DELETE
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement preparedStatement = conexao.prepareStatement(delete);
			preparedStatement.setInt(1, contato.getIdcon());
			preparedStatement.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
