package br.com.acordocerto.web.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.acordocerto.domain.Divida;
import br.com.acordocerto.service.DividaService;
import lombok.Data;

@Data
public class AtualizacaoDividaForm {
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull
	private LocalDateTime dataVencimento;
	@Positive
	private BigDecimal valor;
	public Divida atualizar(Long id, DividaService dividaService) {
		Divida divida = dividaService.getDivida(id).get();
				divida.setDescricao(getDescricao());
				divida.setDataVencimento(getDataVencimento());
				divida.setValor(getValor());
		dividaService.atualizar(divida);
		return divida;
	}
}
