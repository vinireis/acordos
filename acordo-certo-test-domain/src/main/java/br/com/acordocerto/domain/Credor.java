package br.com.acordocerto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

public class Credor {
	private Long id;
	private String nome;
	private Usuario usuario;
	
	public Credor(String nome, Usuario usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}
}
