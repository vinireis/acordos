package br.com.acordocerto.domain;

import javax.persistence.CascadeType;
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
	private String razaoSocial;
	private String cnpj;
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private Usuario usuario;

	public Credor(String razaoSocial, String cnpj, Usuario usuario) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.usuario = usuario;
	}

	public Credor(Long idCredor) {
		this.id = idCredor;
	}

	public String getUsuarioEmail() {
		return this.usuario.getEmail();
	}

	public void setSenha(String senha) {
		this.usuario.setSenha(senha);
	}

}
