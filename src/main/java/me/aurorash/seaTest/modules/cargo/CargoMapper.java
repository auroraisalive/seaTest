package me.aurorash.seaTest.modules.cargo;

import me.aurorash.seaTest.domain.Cargo;
import me.aurorash.seaTest.domain.Setor;
import me.aurorash.seaTest.json.cargo.CargoRequest;
import me.aurorash.seaTest.json.cargo.CargoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CargoMapper {

    public Cargo toDomain(CargoRequest request) {
        Cargo output = new Cargo();
        output.setNome(request.getNome());
        return output;
    }

    public CargoResponse toResponse(Cargo domain) {
        CargoResponse output = new CargoResponse();
        output.setId(domain.getId());
        output.setNome(domain.getNome());
        output.setSetor(domain.getSetor().getNome());
        return output;
    }

    public List<CargoResponse> toResponses(List<Cargo> domains) {
        return domains.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
