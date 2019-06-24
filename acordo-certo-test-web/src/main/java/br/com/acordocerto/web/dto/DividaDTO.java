package br.com.acordocerto.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.acordocerto.domain.Divida;
import br.com.acordocerto.domain.StatusDivida;
import lombok.Getter;

@Getter
public class DividaDTO {
	private Long id;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataVencimento;
	private StatusDivida status;
	private BigDecimal valor;
	private DevedorDTO devedor;
	

	public DividaDTO(Divida divida) {
		super();
		this.id = divida.getId();
		this.descricao = divida.getDescricao();
		this.dataCriacao = divida.getDataCriacao();
		this.dataVencimento = divida.getDataVencimento();
		this.status = divida.getStatus();
		this.valor = divida.getValor();
		this.devedor = new DevedorDTO(divida.getDevedor());
	}

	public static List<DividaDTO> converte(List<Divida> dividas) {
		return dividas.stream().map(DividaDTO::new).collect(Collectors.toList());
	}



}
