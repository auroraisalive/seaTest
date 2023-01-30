package me.aurorash.seaTest.json.setor;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SetorResponse {

    private Integer id;
    private String nome;
    private Map<String, Integer> cargos = new HashMap<>();

}
