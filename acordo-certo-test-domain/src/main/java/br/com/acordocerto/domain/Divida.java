package br.com.acordocerto.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
public class Divida {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Builder.Default
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataVencimento;
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private StatusDivida status = StatusDivida.VENCIDA;
	@ManyToOne
	private Devedor devedor;
	@ManyToOne
	private Credor credor;
	private BigDecimal valor;
	@OneToMany(mappedBy = "divida")
	@Builder.Default
	private List<Mensagens> mensagens = new ArrayList<>();
	private boolean cobrancaJudicial;
}
