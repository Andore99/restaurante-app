package restaurante.com.controller;

import restaurante.com.model.Plato;
import restaurante.com.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/platos")
@Validated
public class PlatoController {

    @Autowired
    private PlatoService service;

    @GetMapping
    public List<Plato> obtenerPlatos() {
        return service.obtenerPlatos();
    }

    @PostMapping
    public Plato guardarPlato(@Valid @RequestBody Plato plato) {
        return service.guardarPlato(plato);
    }
}
