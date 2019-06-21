package br.com.acordocerto.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data

public class Mensagens {
	private Long id;
	private String mensagem;
	private Divida divida;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private Usuario autor;
}
