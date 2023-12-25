package br.com.felipesantos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "time")
public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_time", sequenceName = "seq_time_id", allocationSize = 1)
	@GeneratedValue(generator = "seq_time", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado")
	@Size(max = 50, message = "O nome não pode ter mais que {max} caracteres")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de fundação deve ser informada")
	@Column(name = "data_fundacao", nullable = false)
	private Calendar dataFundacao;
	
	@Column(name = "historia", columnDefinition = "text") // sem limites de caracteres
	private String historia;
	
	@ManyToOne
	@JoinColumn(name = "cidade", 	
		referencedColumnName = "id", 
		nullable = false)
	@NotNull(message = "A cidade deve ser informada")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "usuario", 
		referencedColumnName = "login", 
		nullable = false)
	@NotNull(message = "O usuário deve ser informado")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "tecnico", 
		referencedColumnName = "id", 
		nullable = false)
	@NotNull(message = "O técnico deve ser informado")
	private Pessoa tecnico;
	
	@OneToMany(mappedBy = "time", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			orphanRemoval = true) // remove o time, remove os jogadores
	private List<Jogador> jogadores = new ArrayList<>();
	
	public Time() {
	}
	
	public void adicionarJogador(Jogador jogador) {
		jogador.setTime(this);
		this.jogadores.add(jogador);
	}
	
	public void removerJogador(int index) {
		this.jogadores.remove(index);
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

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public String getHistoria() {
		return historia;
	}
	
	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pessoa getTecnico() {
		return tecnico;
	}

	public void setTecnico(Pessoa tecnico) {
		this.tecnico = tecnico;
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
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
}
