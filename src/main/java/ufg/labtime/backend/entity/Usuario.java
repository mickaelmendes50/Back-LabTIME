package ufg.labtime.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome completo")
    @Getter
    @Setter
    private String nomeCompleto;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome social")
    @Getter
    @Setter
    private String nomeSocial;

    @Column(nullable = true)
    @Getter
    @Setter
    private String dataDeNascimento;

    @Id
    @Getter
    @Setter
    private int codigo;

    @Column(nullable = true)
    @Getter
    @Setter
    private String sexo;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o email")
    @Getter
    @Setter
    private String email;

    @Column(nullable = true)
    @Getter
    @Setter
    private String estado;

    @Column(nullable = true)
    @Getter
    @Setter
    private String municipio;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o numero de acesso")
    @Getter
    @Setter
    private int numeroDeAcessos;

    @Column(nullable = true)
    @Getter
    @Setter
    private String situacao;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar a data de vinculo")
    @Getter
    @Setter
    private String dataDeVinculo;
}
