package me.aurorash.seaTest.modules.trabalhador;

import me.aurorash.seaTest.domain.Trabalhador;
import me.aurorash.seaTest.json.cargo.CargoSimplifiedResponse;
import me.aurorash.seaTest.json.setor.SetorSimplifiedResponse;
import me.aurorash.seaTest.json.trabalhador.TrabalhadorRequest;
import me.aurorash.seaTest.json.trabalhador.TrabalhadorResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrabalhadorMapper {

    public Trabalhador toDomain(TrabalhadorRequest request) {
        Trabalhador output = new Trabalhador();
        output.setNome(request.getNome());
        output.setCpf(request.getCpf());
        return output;
    }

    public TrabalhadorResponse toResponse(Trabalhador domain) {
        TrabalhadorResponse output = new TrabalhadorResponse();
        output.setNome(domain.getNome());
        output.setCPF(domain.getCpf());
        output.setId(domain.getId());
        output.setCargo(new CargoSimplifiedResponse(domain.getCargo().getId(), domain.getCargo().getNome()));
        output.setSetor(new SetorSimplifiedResponse(domain.getSetor().getId(), domain.getSetor().getNome()));
        return output;
    }

    public List<TrabalhadorResponse> toResponses(List<Trabalhador> domains) {
        return domains.stream().map(this::toResponse).collect(Collectors.toList());
    }


}
