package ufg.labtime.backend.entity;

import com.opencsv.bean.CsvBindByPosition;
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
    @CsvBindByPosition(position = 3)
    private String code;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome completo")
    @Getter
    @Setter
    @CsvBindByPosition(position = 0)
    private String fullName;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o nome social")
    @Getter
    @Setter
    @CsvBindByPosition(position = 1)
    private String socialName;

    @Column(nullable = true)
    @Getter
    @Setter
    @CsvBindByPosition(position = 2)
    private String birthDate;

    @Column(nullable = true)
    @Getter
    @Setter
    @CsvBindByPosition(position = 4)
    private String sex;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar o email")
    @Getter
    @Setter
    @CsvBindByPosition(position = 5)
    private String email;

    @Column(nullable = true)
    @Getter
    @Setter
    @CsvBindByPosition(position = 6)
    private String state;

    @Column(nullable = true)
    @Getter
    @Setter
    @CsvBindByPosition(position = 7)
    private String city;

    @Column(nullable = true)
    @Getter
    @Setter
    @CsvBindByPosition(position = 9)
    private String situation;

    @Column(nullable = false)
    @NotEmpty(message = "É necessário informar a data de vinculo")
    @Getter
    @Setter
    @CsvBindByPosition(position = 10)
    private String bondDate;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o numero de acesso")
    @Getter
    @Setter
    @CsvBindByPosition(position = 8)
    private String accessNumber;
}
