package br.com.acordocerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acordocerto.domain.Divida;

public interface DividaRepository extends JpaRepository<Divida, Long> {
}
