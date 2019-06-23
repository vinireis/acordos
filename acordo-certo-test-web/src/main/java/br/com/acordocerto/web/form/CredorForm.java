package br.com.acordocerto.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.domain.Usuario;
import br.com.acordocerto.service.CredorService;
import lombok.Data;

@Data
public class CredorForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String razaoSocial;
	@CNPJ
	private String cnpj;
	@Email
	private String email;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;

	public Credor cadastrar(CredorService devedorService) {
		Credor devedor = new Credor(this.razaoSocial, this.cnpj, new Usuario(this.email, this.senha));
		devedorService.cadastrar(devedor);
		return devedor;
	}
}
