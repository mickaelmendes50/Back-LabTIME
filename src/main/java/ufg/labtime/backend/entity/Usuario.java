package ufg.labtime.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome completo")
    private String nomeCompleto;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome social")
    private String nomeSocial;

    @Column(nullable = true)
    private String dataDeNascimento;

    @Id
    private int codigo;

    @Column(nullable = true)
    private String sexo;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o email")
    private String email;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private String municipio;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o numero de acesso")
    private int numeroDeAcessos;

    @Column(nullable = true)
    private String situacao;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar a data de vinculo")
    private String dataDeVinculo;
}
