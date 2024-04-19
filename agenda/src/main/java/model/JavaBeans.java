package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The idcon. */
	private int idcon;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	/** The endereco. */
	private String endereco;
	
	/** The estado. */
	private String estado;
	
	/** The data niver. */
	private Date dataNiver;

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 * @param endereco the endereco
	 * @param estado the estado
	 * @param dataNiver the data niver
	 */
	public JavaBeans(int idcon, String nome, String fone, String email, String endereco, String estado,
			Date dataNiver) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.endereco = endereco;
		this.estado = estado;
		this.dataNiver = dataNiver;

	}

	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	public int getIdcon() {
		return idcon;
	}

	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the data niver.
	 *
	 * @return the data niver
	 */
	public Date getDataNiver() {
		return dataNiver;
	}

	/**
	 * Sets the data niver.
	 *
	 * @param dataNiver the new data niver
	 */
	public void setDataNiver(Date dataNiver) {
		this.dataNiver = dataNiver;
	}
}
