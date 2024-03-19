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

import br.com.fiap.bombview.model.Filmes;
import br.com.fiap.bombview.repository.FilmesRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("filmes")
@Slf4j
public class FilmesController {

    // REPOSITÓRIO ------------------------------------------------------------------
    @Autowired
    FilmesRepository repository;

    @GetMapping
    public List<Filmes> index() {
        return repository.findAll();
    }

    // CADASTRAR FILMES ------------------------------------------------------------------
    @PostMapping
    @ResponseStatus(CREATED)
    public Filmes create(@RequestBody Filmes filmes) {
        log.info("Cadastrando filme {}", filmes);
        return repository.save(filmes);
    }

    // BUSCAR FILMES ------------------------------------------------------------------
    @GetMapping("{id}")
    public ResponseEntity<Filmes> show(@PathVariable Long id) {
        log.info("buscando filmes com id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // DELETAR FILMES ------------------------------------------------------------------
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando filme {}", id);
        verificarSeFilmeExiste(id);
        repository.deleteById(id);
    }


    // ATUALIZAR FILMES ------------------------------------------------------------------
    @PutMapping("{id}")
    public Filmes update(@PathVariable Long id, @RequestBody Filmes filmes) {
        log.info("atualizar filmes {} para {}", id, filmes);

        verificarSeFilmeExiste(id);
        filmes.setId(id);
        return repository.save(filmes);
    }

    // NOT FOUND!!! 
    private void verificarSeFilmeExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe filme com o id informado"));
    }


}
