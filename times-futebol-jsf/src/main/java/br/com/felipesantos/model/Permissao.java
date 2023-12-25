package br.com.felipesantos.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@NotBlank(message = "O nome da permissão deve ser informado")
	@Size(max = 30, message = "A permissão não deve ter mais que {max} caracteres")
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
	@NotBlank(message = "A descrição deve ser informado")
	@Size(max = 40, message = "A descrição não deve ter mais que {max} caracteres")
	@Column(name = "descricao", length = 40, nullable = false)
	private String descricao;
	
	public Permissao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		return Objects.equals(nome, other.nome);
	}
}
