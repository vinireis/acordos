package br.com.acordocerto.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.acordocerto.domain.Devedor;
import lombok.Getter;

@Getter
public class DevedorDTO {
	private Long id;
	private String nome;
	private String usuarioEmail;
	
	public DevedorDTO(Devedor devedor) {
		this.id = devedor.getId();
		this.nome = devedor.getNome();
		this.usuarioEmail = devedor.getUsuarioEmail();
	}

	public static List<DevedorDTO> converte(List<Devedor> devedores) {
		return devedores.stream().map(DevedorDTO::new).collect(Collectors.toList());
	}
}
