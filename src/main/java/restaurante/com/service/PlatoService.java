package restaurante.com.service;

import restaurante.com.model.Plato;
import restaurante.com.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    
    @Autowired
    private PlatoRepository repository;

    public List<Plato> obtenerPlatos() {
        return repository.findAll();
    }

    public Plato guardarPlato(Plato plato) {
        return repository.save(plato);
    }
}