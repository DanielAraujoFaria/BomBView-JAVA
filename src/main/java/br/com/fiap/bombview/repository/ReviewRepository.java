package br.com.fiap.bombview.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bombview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    Page<Review> findByFilmesNomeIgnoreCase(String filmes, Pageable pageable);

}
