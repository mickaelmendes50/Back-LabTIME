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
    private String dataDeNascimento;

    @Id
    private int codigo;
    private String sexo;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o email")
    private String email;
    private String estado;
    private String municipio;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o numero de acesso")
    private int numeroDeAcessos;
    private String situacao;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar a data de vinculo")
    private String dataDeVinculo;
}
