package br.com.felipesantos.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank(message = "O nome não pode ser em branco")
	@Size(max = 50, message = "O nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@NotBlank(message = "A UF não pode ser em branco")
	@Size(min = 2, max = 2, message = "A UF não pode ter mais que {max} caracteres")
	@Column(name = "uf", nullable = false, length = 50)
	private String uf;
	
	public Estado() {
		
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}	
}
