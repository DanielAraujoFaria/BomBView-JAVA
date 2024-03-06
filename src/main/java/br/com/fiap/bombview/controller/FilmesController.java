package br.com.fiap.bombview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.bombview.model.Filmes;

public class FilmesController {
    
    /* LISTAR FILMES */
    @RequestMapping(
        method = RequestMethod.GET,
        path = "/filmes",
        produces = "application/json"
    )
    @ResponseBody
    public Filmes index(){
        return new Filmes(1L, "Em Ritmo de Fuga", "Ação", "1h 55m", 14);
    }

    /* CADASTRAR FILME */
    @RequestMapping(
        method = RequestMethod.POST,
        path = "/filmes",
        produces = "application/json",
        consumes = "application/json"
    )
    @ResponseBody
    public void create(){
        System.out.println("Filme Cadastrado!");
    }

    /* DETALHES DO FILME */
    @RequestMapping(
        method = RequestMethod.GET,
        path = "/filmes/{id}",
        produces = "application/json"
    )
    @ResponseBody
    public Filmes show(){
        return new Filmes(1L, "Em Ritmo de Fuga", "Ação", "1h 55m", 14);
    }

    /* ATUALIZAR FILME */
    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/filmes/{id}",
        produces = "application/json",
        consumes = "application/json"
    )
    @ResponseBody
    public void update(Long id){
        System.out.println("Filme Atualizado!");
    }
    
    /* DELETAR FILME */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/filmes/{id}",
            produces = "application/json"
    )
    @ResponseBody
    public void delete(Long id) {
        System.out.println("Filme Deletado!");
    }


}
