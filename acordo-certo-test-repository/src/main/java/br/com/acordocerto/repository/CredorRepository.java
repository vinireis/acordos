package br.com.acordocerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acordocerto.domain.Credor;

public interface CredorRepository extends JpaRepository<Credor, Long> {
	public List<Credor> findByRazaoSocialContainingIgnoreCase(String razaoSocial);
}
