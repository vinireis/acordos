package br.com.acordocerto.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.domain.Usuario;
import br.com.acordocerto.service.DevedorService;
import lombok.Data;

@Data
public class DevedorForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	@CPF
	private String cpf;
	@NotNull @NotEmpty @Length(min = 9)
	private String telefone;
	@Email
	private String email;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;

	public Devedor cadastrar(DevedorService devedorService) {
		Devedor devedor = new Devedor(this.nome, this.cpf, this.telefone, new Usuario(this.email, this.senha));
		devedorService.cadastrar(devedor);
		return devedor;
	}
}
