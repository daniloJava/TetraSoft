package br.com.tetrasoft.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CADASTRO")
public class Cadastro implements Serializable{

	public enum Sexo {
		MASCULINO, FEMININO
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CADASTRO")
	private Long idCadastro;

	@Column(name = "NOME_CADASTRO")
	private String nome;

	@Column(name = "EMAIL_CADASTRO")
	private String email;

	@Column(name = "ENDERECO_CADASTRO")
	private String endereco;

	@Column(name = "TELEFONE_CADASTRO")
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO_CADASTRO", nullable = false)
	private Sexo sexo;

	public Long getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(Long idCadastro) {
		this.idCadastro = idCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
