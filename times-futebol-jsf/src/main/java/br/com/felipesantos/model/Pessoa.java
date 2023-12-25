package br.com.felipesantos.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

//import br.com.felipesantos.utils.CPF;


@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado")
	@Size(max = 50, message = "O nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@CPF(message = "O CPF deve ser válido")
	@NotBlank(message = "O CPF deve ser informado")
	@Size(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
	@Column(name = "cpf", length = 14, nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de nascimento deve ser informada")
	@Column(name = "data_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	public Pessoa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
}
