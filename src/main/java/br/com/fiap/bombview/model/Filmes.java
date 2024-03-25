package br.com.fiap.bombview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Filmes {   

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{filmes.nome.notblank}")
    @Size(min = 3, max = 255)
    private String nome;

    private String duracao;

    @Positive(message = "O VALOR PRECISA SER POSITIVO")
    private int classificacao;
}
    