package br.com.fiap.bombview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bombview.model.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
    
}
