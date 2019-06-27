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

import br.com.acordocerto.domain.Divida;
import br.com.acordocerto.service.DividaService;
import br.com.acordocerto.web.dto.DividaDTO;
import br.com.acordocerto.web.form.AtualizacaoDividaForm;
import br.com.acordocerto.web.form.DividaForm;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dividas")
public class DividaController {
	private DividaService dividaService;

	public DividaController(DividaService dividaService) {
		this.dividaService = dividaService;
	}

	@GetMapping
	public List<DividaDTO> listar() {
		return DividaDTO.converte(dividaService.getDividas());
	}

	@GetMapping(value = "/credor/{idCredor}")
	public List<DividaDTO> listarByIdCredor(@PathVariable Long idCredor) {
		return DividaDTO.converte(dividaService.getDividasByIdCredor(idCredor));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<DividaDTO> cadastrar(@RequestBody @Valid DividaForm form, UriComponentsBuilder uriBuilder) {
		try {
			Divida divida = form.cadastrar(dividaService);
			URI uri = uriBuilder.path("/dividas/{id}").buildAndExpand(divida.getId()).toUri();
			return ResponseEntity.created(uri).body(new DividaDTO(divida));
		} catch (NotFoundException e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DividaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoDividaForm form) {
		Optional<Divida> optional = dividaService.getDivida(id);
		if (optional.isPresent()) {
			Divida divida = form.atualizar(id, dividaService);
			return ResponseEntity.ok(new DividaDTO(divida));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DividaDTO> buscar(@PathVariable Long id) {
		Optional<Divida> optional = dividaService.getDivida(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DividaDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Divida> optional = dividaService.getDivida(id);
		if (optional.isPresent()) {
			dividaService.remove(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
