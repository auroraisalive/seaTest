package me.aurorash.seaTest.modules.cargo;

import me.aurorash.seaTest.commons.NotFoundException;
import me.aurorash.seaTest.domain.Cargo;
import me.aurorash.seaTest.domain.Setor;
import me.aurorash.seaTest.modules.setor.SetorService;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Service
public class CargoService {

    private final CargoRepository repository;
    private final CargoMapper mapper;
    private final SetorService setorService;

    public CargoService(CargoRepository repository, CargoMapper mapper, SetorService setorService) {
        this.repository = repository;
        this.mapper = mapper;
        this.setorService = setorService;
    }

    public Cargo create(Cargo cargo, Integer idSetor) {
        Setor setor = this.setorService.getById(idSetor);
        System.out.println(setor.getId());
        cargo.setSetor(setor);
        return this.repository.save(cargo);
    }

    public List<Cargo> getAll() {
        return this.repository.findAll();
    }

    public Cargo getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum cargo encontrado com o id " + id));
    }

    public Cargo update(Integer id, Cargo cargo, Integer idSetor) {
        Cargo existingCargo = this.getById(id);
        cargo.setId(id);
        Setor newSetor = this.setorService.getById(idSetor);
        cargo.setSetor(newSetor);

        return this.repository.save(cargo);
    }

    public void delete(Integer id) {
        Cargo cargo = this.getById(id);
        this.repository.delete(cargo);
    }

}
