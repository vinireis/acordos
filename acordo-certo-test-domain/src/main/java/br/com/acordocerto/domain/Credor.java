package br.com.acordocerto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

@Entity
public class Credor {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToOne
	private Usuario usuario;
	
	public Credor(String nome, Usuario usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}
}
