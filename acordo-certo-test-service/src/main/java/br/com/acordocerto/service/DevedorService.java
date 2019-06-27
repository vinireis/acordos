package br.com.acordocerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.repository.DevedorRepository;

@Service
public class DevedorService {
	private DevedorRepository devedorRepository;

	public DevedorService(DevedorRepository devedorRepository) {
		this.devedorRepository = devedorRepository;
	}

	public List<Devedor> getDevedores(String nomeDevedor) {
		List<Devedor> devedores;
		if (nomeDevedor == null) {
			devedores = devedorRepository.findAll();
		} else {
			devedores = devedorRepository.findByNomeContainingIgnoreCase(nomeDevedor);
		}
		return devedores;
	}

	public void cadastrar(Devedor devedor) {
		devedorRepository.save(devedor);
	}

	public void atualizar(Devedor devedor) {
		devedorRepository.save(devedor);
	}

	public Optional<Devedor> getDevedor(Long id) {
		return devedorRepository.findById(id);
	}

	public void remove(Long id) {
		devedorRepository.deleteById(id);
	}
}
