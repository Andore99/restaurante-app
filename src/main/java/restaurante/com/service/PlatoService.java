package restaurante.com.service;

import restaurante.com.model.Plato;
import restaurante.com.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository repository;

    public List<Plato> obtenerPlatos() {
        return repository.findAll();
    }

    @Retryable(value = RuntimeException.class, maxAttempts = 3)
    public Plato guardarPlato(Plato plato) {
        if (plato == null) {
            throw new IllegalArgumentException("El plato no puede ser nulo");
        }
        return repository.save(plato);
    }

    public Optional<Plato> buscarPlatoPorId(Long id) {
        return repository.findById(id);
    }
}
