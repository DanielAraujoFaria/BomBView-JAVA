package br.com.fiap.bombview.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("filmes")
@Slf4j
@CacheConfig(cacheNames = "filmes")
@Tag(name = "filmes")
public class FilmesController {

    // REPOSITÓRIO ------------------------------------------------------------------
    @Autowired
    FilmesRepository repository;

    @GetMapping
    @Cacheable
    @Operation(
        summary = "Listar filmes",
        description = "Array de filmes cadastrados"
    )
    public List<Filmes> index() {
        return repository.findAll();
    }

    // CADASTRAR FILMES ------------------------------------------------------------------
    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Cadastrar filme",
        description = "Cadastrar um novo filme"
    )
    public Filmes create(@RequestBody @Valid Filmes filmes) {
        log.info("Cadastrando filme {}", filmes);
        return repository.save(filmes);
    }

    // BUSCAR FILMES ------------------------   ------------------------------------------
    @GetMapping("{id}")
    @Operation(
        summary = "Buscar Filmes",
        description = "Buscar um filme por id"
    )
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
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Deletar Filmes",
        description = "Deletar filme por id"
    )
    public void destroy(@PathVariable Long id) {
        log.info("apagando filme {}", id);
        verificarSeFilmeExiste(id);
        repository.deleteById(id);
    }


    // ATUALIZAR FILMES ------------------------------------------------------------------
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "Atulizar Filme",
        description = "Atualizar um filme específico"
    )
    public Filmes update(@PathVariable Long id, @RequestBody @Valid Filmes filmes) {
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
