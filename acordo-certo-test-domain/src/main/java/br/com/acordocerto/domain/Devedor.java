package br.com.acordocerto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Devedor {
	private Long id;
	private String nome;
	private Usuario usuario;

	public Devedor(String nome, Usuario usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}
}
