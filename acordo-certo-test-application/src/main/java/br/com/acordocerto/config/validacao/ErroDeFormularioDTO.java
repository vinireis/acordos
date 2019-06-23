package br.com.acordocerto.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErroDeFormularioDTO {
	private String campo;
	private String erro;
}
