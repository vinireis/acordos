package br.com.acordocerto.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.service.DevedorService;
import lombok.Data;

@Data
public class AtualizacaoDevedorForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	@NotNull @NotEmpty @Length(min = 9)
	private String telefone;
	@Email
	private String email;
	@NotNull @NotEmpty @Length(min = 3)
	private String senha;

	public Devedor atualizar(Long id, DevedorService devedorService) {
		Devedor devedor = devedorService.getDevedor(id).get();
		devedor.setNome(this.nome);
		devedor.setTelefone(this.telefone);
		devedor.setEmail(this.email);
		devedor.setSenha(this.senha);
		return devedor;
	}
}