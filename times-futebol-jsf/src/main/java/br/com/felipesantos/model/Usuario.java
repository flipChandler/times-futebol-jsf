package br.com.felipesantos.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotBlank(message = "O login deve ser informado")
	@Size(max = 20, message = "O login não pode ter mais que {max} caracteres")
	@Column(name = "login", length = 20, nullable = false)
	private String login;
	
	@NotBlank(message = "A senha deve ser informada")
	@Size(max = 20, message = "A senha não pode ter mais que {max} caracteres")
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	@NotBlank(message = "O nome deve ser informado")
	@Size(max = 50, message = "O nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Email(message = "O email deve ser válido")
	@NotBlank(message = "O email deve ser informado")
	@Size(max = 50, message = "O email não pode ter mais que {max} caracteres")
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@NotNull(message = "O campo ativo deve ser informado")
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de cadastro deve ser informada")
	@Column(name = "data_cadastro", nullable = false)
	private Calendar dataCadastro;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_permissao",
			joinColumns = 
			@JoinColumn(name = "usuario_login", referencedColumnName = "login", nullable = false),
			inverseJoinColumns = 
			@JoinColumn(name = "permissao_nome", referencedColumnName = "nome", nullable = false)
	)
	private Set<Permissao> permissoes = new HashSet<>();
	
	public Usuario() {
		this.dataCadastro = Calendar.getInstance();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	
	
	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}	
}
