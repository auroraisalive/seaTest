package me.aurorash.seaTest.modules.setor;

import io.swagger.annotations.Api;
import me.aurorash.seaTest.domain.Setor;
import me.aurorash.seaTest.json.setor.SetorRequest;
import me.aurorash.seaTest.json.setor.SetorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setor")
@Api
public class SetorController {

    private final SetorMapper mapper;
    private final SetorService service;

    public SetorController(SetorMapper mapper, SetorService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public SetorResponse create(@RequestBody SetorRequest request) {
        return this.mapper.toResponse(this.service.save(this.mapper.toDomain(request)));
    }

    @GetMapping("/all")
    public List<SetorResponse> getAll() {
        return this.mapper.toResponses(this.service.getAll());
    }

    @GetMapping("/{id}")
    public SetorResponse getById(@PathVariable Integer id) {
        return this.mapper.toResponse(this.service.getById(id));
    }

    @PutMapping("/{id}")
    public SetorResponse update(@PathVariable Integer id, @RequestBody SetorRequest request) {
        return this.mapper.toResponse(this.service.update(id, this.mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }

}
