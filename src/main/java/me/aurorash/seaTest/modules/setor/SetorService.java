package me.aurorash.seaTest.modules.setor;

import me.aurorash.seaTest.commons.BadRequestException;
import me.aurorash.seaTest.commons.NotFoundException;
import me.aurorash.seaTest.domain.Setor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    private final SetorRepository repository;

    public SetorService(SetorRepository setorRepository, SetorMapper setorMapper) {
        this.repository = setorRepository;
    }

    public List<Setor> getAll() {
        return repository.findAll();
    }

    public Setor getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum setor encontrado com o id " + id));
    }

    public Setor save(Setor setor) {
        if(this.repository.findByName(setor.getNome()).isPresent()) throw new BadRequestException("Já existe um setor com o nome " + setor.getNome());
        return this.repository.save(setor);
    }

    public Setor update(Integer id, Setor setor) {
        Setor existingSetor = this.getById(id);
        setor.setId(id);
        return this.repository.save(setor);
    }

    public void delete(Integer id) {
        Setor setor = this.getById(id);
        repository.delete(setor);
    }



}
