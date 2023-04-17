package ufg.labtime.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Id
    @Getter
    @Setter
    private String code;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome completo")
    @Getter
    @Setter
    private String fullName;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome social")
    @Getter
    @Setter
    private String socialName;

    @Column(nullable = true)
    @Getter
    @Setter
    private String birthDate;

    @Column(nullable = true)
    @Getter
    @Setter
    private String sex;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o email")
    @Getter
    @Setter
    private String email;

    @Column(nullable = true)
    @Getter
    @Setter
    private String state;

    @Column(nullable = true)
    @Getter
    @Setter
    private String city;

    @Column(nullable = true)
    @Getter
    @Setter
    private String situation;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar a data de vinculo")
    @Getter
    @Setter
    private String bondDate;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o numero de acesso")
    @Getter
    @Setter
    private String accessNumber;
}
