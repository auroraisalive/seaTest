package me.aurorash.seaTest.modules.trabalhador;


import me.aurorash.seaTest.commons.BadRequestException;
import me.aurorash.seaTest.commons.NotFoundException;
import me.aurorash.seaTest.domain.Cargo;
import me.aurorash.seaTest.domain.Trabalhador;
import me.aurorash.seaTest.modules.cargo.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhadorService {

    private final TrabalhadorRepository repository;
    private final CargoService cargoService;

    public TrabalhadorService(TrabalhadorRepository repository, CargoService cargoService) {
        this.repository = repository;
        this.cargoService = cargoService;
    }


    public List<Trabalhador> getAll() {
        return repository.findAll();
    }

    public Trabalhador getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum trabalhador encontrado com o id " + id));
    }

    public Trabalhador save(Trabalhador trabalhador, Integer idCargo) {
        if(this.repository.findByCPF(trabalhador.getCpf()).isPresent()) throw new BadRequestException("Já existe um trabalhador com o CPF " + trabalhador.getCpf());
        Cargo cargo = this.cargoService.getById(idCargo);
        trabalhador.setCargo(cargo);
        trabalhador.setSetor(cargo.getSetor());
        return this.repository.save(trabalhador);
    }

    public Trabalhador update(Integer id, Trabalhador trabalhador, Integer idCargo) {
        Trabalhador existingTrabalhador = this.getById(id);
        trabalhador.setId(id);

        Cargo newCargo = this.cargoService.getById(idCargo);
        trabalhador.setCargo(newCargo);
        trabalhador.setSetor(newCargo.getSetor());

        return this.repository.save(trabalhador);
    }

    public void delete(Integer id) {
        Trabalhador trabalhador = this.getById(id);
        repository.delete(trabalhador);
    }


}
