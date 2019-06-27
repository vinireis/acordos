package br.com.acordocerto.web.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.domain.Divida;
import br.com.acordocerto.domain.StatusDivida;
import br.com.acordocerto.service.DividaService;
import javassist.NotFoundException;
import lombok.Data;

@Data
public class DividaForm {
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull
	private LocalDateTime dataVencimento;
	@NotNull
	private Long idDevedor;
	@NotNull
	private Long idCredor;
	@Positive
	private BigDecimal valor;
	@NotNull
	private StatusDivida status;
	public Divida cadastrar(DividaService dividaService) throws NotFoundException {
		Divida divida = Divida.builder()
				.descricao(getDescricao())
				.dataVencimento(getDataVencimento())
				.credor(new Credor(idCredor))
				.devedor(new Devedor(idDevedor))
				.status(getStatus())
				.valor(getValor())
				.build();
		dividaService.cadastrar(divida);
		return divida;
	}
}
