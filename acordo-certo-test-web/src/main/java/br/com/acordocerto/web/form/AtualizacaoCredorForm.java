package br.com.acordocerto.web.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.service.CredorService;
import lombok.Data;

@Data
public class AtualizacaoCredorForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String razaoSocial;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;

	public Credor atualizar(Long id, CredorService credorService) {
		Credor credor = credorService.getCredor(id).get();
		credor.setRazaoSocial(credor.getRazaoSocial());
		credor.setSenha(this.senha);
		return credor;
	}
}