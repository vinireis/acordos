package br.com.acordocerto.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.acordocerto.domain.Credor;
import lombok.Getter;

@Getter
public class CredorDTO {
	private Long id;
	private String razaoSocial;
	private String usuarioEmail;
	
	public CredorDTO(Credor credor) {
		this.id = credor.getId();
		this.razaoSocial = credor.getRazaoSocial();
		this.usuarioEmail = credor.getUsuarioEmail();
	}

	public static List<CredorDTO> converte(List<Credor> credores) {
		return credores.stream().map(CredorDTO::new).collect(Collectors.toList());
	}
}
