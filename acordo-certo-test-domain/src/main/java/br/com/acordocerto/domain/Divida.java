package br.com.acordocerto.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

public class Divida {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private StatusDivida status = StatusDivida.VENCIDA;
	private Devedor devedor;
	private Credor credor;
	private BigDecimal valor;
	private List<Mensagens> mensagens = new ArrayList<>();
}
