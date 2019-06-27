package br.com.acordocerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acordocerto.domain.Divida;

public interface DividaRepository extends JpaRepository<Divida, Long> {
	public List<Divida> findByDescricaoContainingIgnoreCase(String descricao);

	public List<Divida> findByCredorId(Long idCredor);
}
