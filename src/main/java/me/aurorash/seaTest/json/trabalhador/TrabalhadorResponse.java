package me.aurorash.seaTest.json.trabalhador;

import lombok.Data;
import me.aurorash.seaTest.json.cargo.CargoSimplifiedResponse;
import me.aurorash.seaTest.json.setor.SetorSimplifiedResponse;
import me.aurorash.seaTest.modules.setor.SetorService;

@Data
public class TrabalhadorResponse {

    private Integer id;
    private CargoSimplifiedResponse cargo;

    private SetorSimplifiedResponse setor;

    private String nome;

    private String CPF;

}
