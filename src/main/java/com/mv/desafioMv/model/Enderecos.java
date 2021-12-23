package com.mv.desafioMv.model;

import com.mv.desafioMv.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "enderecos")

public class Enderecos {

    @NotNull
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    @Size(max = 60)
    @Column(name = "rua")
    private String rua;

    @NotBlank
    @Size(max = 60)
    @Column(name = "bairro")
    private String bairro;

    @NotBlank
    @Size(max = 60)
    @Column(name = "cidade")
    private String cidade;

    @NotBlank
    @Size(max = 60)
    @Column(name = "estado")
    private String estado;

    @NotBlank
    @Size(max = 60)
    @Column(name = "complemento")
    private String complemento;
}
