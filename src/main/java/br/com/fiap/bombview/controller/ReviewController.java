package br.com.fiap.bombview.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.bombview.model.Review;
import br.com.fiap.bombview.repository.ReviewRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("review")
@Slf4j
public class ReviewController {
    
    @Autowired
    ReviewRepository repository;

    @GetMapping
    public List<Review> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Review create(@RequestBody @Valid Review review) {
        log.info("Cadastrando review {}", review);
        return repository.save(review);
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> show(@PathVariable Long id) {
        log.info("buscando reviews com id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando review {}", id);
        verificarSeReviewExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Review update(@PathVariable Long id, @RequestBody @Valid Review review) {
        log.info("atualizar review {} para {}", id, review);

        verificarSeReviewExiste(id);
        review.setId(id);
        return repository.save(review);
    }

    private void verificarSeReviewExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe review com o id informado"));
    }

}
