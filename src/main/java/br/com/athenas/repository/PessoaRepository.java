package br.com.athenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.athenas.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}