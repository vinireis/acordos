package br.com.acordocerto.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

@Entity
public class Devedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private Usuario usuario;

	public Devedor(Long idDevedor) {
		this.id = idDevedor;
	}

	public Devedor(String nome, String cpf, String telefone, Usuario usuario) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.usuario = usuario;
	}

	public String getUsuarioEmail() {
		return this.usuario.getEmail();
	}

	public void setEmail(String email) {
		this.usuario.setEmail(email);
	}

	public void setSenha(@NotNull @NotEmpty @Length(min = 3) String senha) {
		this.usuario.setSenha(senha);
	}
}
