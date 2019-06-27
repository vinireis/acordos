package br.com.acordocerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.repository.CredorRepository;

@Service
public class CredorService {
	private CredorRepository credorRepository;

	public CredorService(CredorRepository credorRepository) {
		this.credorRepository = credorRepository;
	}

	public List<Credor> getCredores(String nomeCredor) {
		List<Credor> credores;
		if (nomeCredor == null) {
			credores = credorRepository.findAll();
		} else {
			credores = credorRepository.findByRazaoSocialContainingIgnoreCase(nomeCredor);
		}
		return credores;
	}

	public void cadastrar(Credor credor) {
		credorRepository.save(credor);
	}

	public void atualizar(Credor credor) {
		credorRepository.save(credor);
	}

	public Optional<Credor> getCredor(Long id) {
		return credorRepository.findById(id);
	}

	public void remove(Long id) {
		credorRepository.deleteById(id);
	}
}
