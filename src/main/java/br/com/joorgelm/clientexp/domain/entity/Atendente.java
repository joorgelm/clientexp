package br.com.joorgelm.clientexp.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Atendente {

    @Id
    private String id;

    @NotNull
    private String nome;

    private String email;
    private String password;

}
