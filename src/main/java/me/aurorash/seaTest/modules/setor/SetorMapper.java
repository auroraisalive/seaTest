package me.aurorash.seaTest.modules.setor;

import me.aurorash.seaTest.domain.Cargo;
import me.aurorash.seaTest.domain.Setor;
import me.aurorash.seaTest.json.setor.SetorRequest;
import me.aurorash.seaTest.json.setor.SetorResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SetorMapper {

    public Setor toDomain(SetorRequest request) {
        Setor output = new Setor();
        output.setNome(request.getNome());
        return output;
    }

    public SetorResponse toResponse(Setor domain) {
        SetorResponse output = new SetorResponse();
        output.setNome(domain.getNome());
        output.setId(domain.getId());
        output.setCargos(domain.getCargos().stream().collect(Collectors.toMap(Cargo::getNome, Cargo::getId)));
        return output;
    }

    public List<SetorResponse> toResponses(List<Setor> domains) {
        return domains.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
