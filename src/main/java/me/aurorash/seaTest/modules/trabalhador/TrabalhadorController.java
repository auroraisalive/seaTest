package me.aurorash.seaTest.modules.trabalhador;

import io.swagger.annotations.Api;
import me.aurorash.seaTest.json.setor.SetorRequest;
import me.aurorash.seaTest.json.setor.SetorResponse;
import me.aurorash.seaTest.json.trabalhador.TrabalhadorRequest;
import me.aurorash.seaTest.json.trabalhador.TrabalhadorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhadores")
@Api
public class TrabalhadorController {

    private final TrabalhadorService service;
    private final TrabalhadorMapper mapper;


    public TrabalhadorController(TrabalhadorService service, TrabalhadorMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public TrabalhadorResponse create(@RequestBody TrabalhadorRequest request) {
        return this.mapper.toResponse(this.service.save(this.mapper.toDomain(request), request.getIdCargo()));
    }

    @GetMapping("/all")
    public List<TrabalhadorResponse> getAll() {
        return this.mapper.toResponses(this.service.getAll());
    }

    @GetMapping("/{id}")
    public TrabalhadorResponse getById(@PathVariable Integer id) {
        return this.mapper.toResponse(this.service.getById(id));
    }

    @PutMapping("/{id}")
    public TrabalhadorResponse update(@PathVariable Integer id, @RequestBody TrabalhadorRequest request) {
        return this.mapper.toResponse(this.service.update(id, this.mapper.toDomain(request), request.getIdCargo()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }

}
