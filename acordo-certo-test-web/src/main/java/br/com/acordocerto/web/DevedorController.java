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

import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.service.DevedorService;
import br.com.acordocerto.web.dto.DevedorDTO;
import br.com.acordocerto.web.form.AtualizacaoDevedorForm;
import br.com.acordocerto.web.form.DevedorForm;

@RestController
@RequestMapping("/devedores")
public class DevedorController {
	private DevedorService devedorService;

	public DevedorController(DevedorService devedorService) {
		this.devedorService = devedorService;
	}

	@GetMapping
	public List<DevedorDTO> listar(String nomeDevedor) {
		return DevedorDTO.converte(devedorService.getDevedores(nomeDevedor));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<DevedorDTO> cadastrar(@RequestBody @Valid DevedorForm form, UriComponentsBuilder uriBuilder) {
		Devedor devedor = form.cadastrar(devedorService);

		URI uri = uriBuilder.path("/devedores/{id}").buildAndExpand(devedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new DevedorDTO(devedor));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DevedorDTO> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoDevedorForm form) {
		Optional<Devedor> optional = devedorService.getDevedor(id);
		if (optional.isPresent()) {
			Devedor devedor = form.atualizar(id, devedorService);
			return ResponseEntity.ok(new DevedorDTO(devedor));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DevedorDTO> buscar(@PathVariable Long id) {
		Optional<Devedor> optional = devedorService.getDevedor(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DevedorDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Devedor> optional = devedorService.getDevedor(id);
		if (optional.isPresent()) {
			devedorService.remove(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
