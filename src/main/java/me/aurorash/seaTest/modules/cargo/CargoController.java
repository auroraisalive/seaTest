package me.aurorash.seaTest.modules.cargo;

import io.swagger.annotations.Api;
import me.aurorash.seaTest.json.cargo.CargoRequest;
import me.aurorash.seaTest.json.cargo.CargoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@Api
public class CargoController {

    private final CargoService service;
    private final CargoMapper mapper;

    public CargoController(CargoService service, CargoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public CargoResponse create(@RequestBody CargoRequest request) {
        return this.mapper.toResponse(this.service.create(this.mapper.toDomain(request), request.getIdSetor()));
    }

    @GetMapping("/all")
    public List<CargoResponse> getAll() {
        return this.mapper.toResponses(this.service.getAll());
    }

    @GetMapping("/{id}")
    public CargoResponse getById(@PathVariable Integer id) {
        return this.mapper.toResponse(this.service.getById(id));
    }

    @PutMapping("/{id}")
    public CargoResponse update(@PathVariable Integer id, @RequestBody CargoRequest request) {
        return this.mapper.toResponse(this.service.update(id, this.mapper.toDomain(request), request.getIdSetor()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }

}
