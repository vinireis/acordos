package br.com.acordocerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acordocerto.domain.Devedor;

public interface DevedorRepository extends JpaRepository<Devedor, Long> {
	public List<Devedor> findByNomeContains(String nomeDevedor);
}
