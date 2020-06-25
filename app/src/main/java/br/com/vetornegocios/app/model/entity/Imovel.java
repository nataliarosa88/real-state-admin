package br.com.vetornegocios.app.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @Column(nullable = false, length = 254)
    @NotNull(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(nullable = false, length = 254)
    @NotNull(message = "{campo.dormitorios.obrigatorio}")
    private String dormitorio;

    @Column(nullable = false, length = 254)
    @NotNull(message = "{campo.tamanho.obrigatorio}")
    private String tamanho;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}