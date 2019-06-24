package br.com.acordocerto.web;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.service.CredorService;
import br.com.acordocerto.web.dto.CredorDTO;
import br.com.acordocerto.web.form.AtualizacaoCredorForm;
import br.com.acordocerto.web.form.CredorForm;

@RestController
@RequestMapping("/credores")
public class CredorController {
	private CredorService credorService;

	public CredorController(CredorService credorService) {
		this.credorService = credorService;
	}

	@GetMapping
	public List<CredorDTO> listar(String razaoSocialCredor) {
		return CredorDTO.converte(credorService.getCredores(razaoSocialCredor));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CredorDTO> cadastrar(@RequestBody @Valid CredorForm form, UriComponentsBuilder uriBuilder) {
		Credor credor = form.cadastrar(credorService);

		URI uri = uriBuilder.path("/credores/{id}").buildAndExpand(credor.getId()).toUri();
		return ResponseEntity.created(uri).body(new CredorDTO(credor));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CredorDTO> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoCredorForm form) {
		Optional<Credor> optional = credorService.getCredor(id);
		if (optional.isPresent()) {
			Credor credor = form.atualizar(id, credorService);
			return ResponseEntity.ok(new CredorDTO(credor));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CredorDTO> buscar(@PathVariable Long id) {
		Optional<Credor> optional = credorService.getCredor(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new CredorDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Credor> optional = credorService.getCredor(id);
		if (optional.isPresent()) {
			credorService.remove(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
