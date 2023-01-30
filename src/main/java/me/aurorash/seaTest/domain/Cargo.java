package me.aurorash.seaTest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargos", schema = "seatest")
@Getter
@Setter
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Trabalhador> trabalhadores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;

}
