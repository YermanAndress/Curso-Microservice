package co.edu.uceva.cursomicroservice.domain.repository;

import co.edu.uceva.cursomicroservice.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
