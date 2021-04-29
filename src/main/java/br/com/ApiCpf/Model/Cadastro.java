package br.com.ApiCpf.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_Cadastro")
public class Cadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Nome não pode ser em branco")
	@NotNull(message = "Nome não pode vazio")
	private String Nome;
	
	@NotBlank(message = "Nascimento não pode ser em branco")
	@NotNull(message = "Nascimento não pode vazio")
	private String Nascimento;
	
	@CPF(message = "Cpf INVALIDO")
	@NotBlank(message = "Cpf não pode ser em branco")
	@NotNull(message = "Cpf não pode vazio")
	@Column(unique = true)
	@Size(max = 11)
	private String Cpf;
	
	@Email(message = "email invalido")
	@NotBlank(message = "Email não pode ser em branco")
	@NotNull(message = "Email não pode vazio")
	private String email;
	
	private LocalDateTime criadoEm = LocalDateTime.now();


	public Cadastro(
			@NotBlank(message = "Nome não pode ser em branco") @NotNull(message = "Nome não pode vazio") String nome,
			@NotBlank(message = "Nascimento não pode ser em branco") @NotNull(message = "Nascimento não pode vazio") String nascimento,
			@CPF(message = "Cpf INVALIDO") @NotBlank(message = "Cpf não pode ser em branco") @NotNull(message = "Cpf não pode vazio") @Size(max = 11) String cpf,
			@Email(message = "email invalido") @NotBlank(message = "Email não pode ser em branco") @NotNull(message = "Email não pode vazio") String email) {

		this.Nome = nome;
		this.Nascimento = nascimento;
		this.Cpf  = cpf;
		this.email = email;
	}


	public Long getId() {
		return Id;
	}


	public String getNome() {
		return Nome;
	}


	public String getNascimento() {
		return Nascimento;
	}


	public String getCpf() {
		return Cpf;
	}


	public String getEmail() {
		return email;
	}


	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

}
	
