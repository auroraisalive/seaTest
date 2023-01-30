package me.aurorash.seaTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "setores", schema = "seatest")
@Getter
@Setter
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
    private List<Trabalhador> trabalhadores = new ArrayList<>();

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
    private List<Cargo> cargos = new ArrayList<>();

}
