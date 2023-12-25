package br.com.felipesantos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jogador")
public class Jogador extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "O peso deve ser informado")
	@Column(name = "peso", nullable = false, columnDefinition = "numeric(6,3)") // ex.: 100,546
	private Double peso;
	
	@NotNull(message = "A altura deve ser informada")
	@Column(name = "altura", nullable = false, columnDefinition = "numeric(4,2)") // ex.: 10,23
	private Double altura;
	
	@ManyToOne
	@JoinColumn(name = "posicao", referencedColumnName = "id", nullable = false)
	@NotNull(message = "A posição deve ser informada")
	private Posicao posicao;
	
	@ManyToOne
	@JoinColumn(name = "time", referencedColumnName = "id", nullable = false)
	@NotNull(message = "O time deve ser informado")
	private Time time;	
	
	public Jogador() {
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getAltura() {
		return altura;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public Time getTime() {
		return time;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}		
}
