package br.com.fiap.bombview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filmes {   

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{filmes.nome.notblank}")
    @Size(min = 3, max = 255)
    private String nome;

    private String genero;

    private String duracao;

    @Positive(message = "O VALOR PRECISA SER POSITIVO")
    private int classificacao;

    private String descricao;
}
    