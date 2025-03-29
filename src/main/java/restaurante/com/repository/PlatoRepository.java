package restaurante.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurante.com.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
}