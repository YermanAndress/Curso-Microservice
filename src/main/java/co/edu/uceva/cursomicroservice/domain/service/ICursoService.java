package co.edu.uceva.cursomicroservice.domain.service;

import co.edu.uceva.cursomicroservice.domain.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ICursoService {
    Curso save(Curso curso);
    void delete(Curso curso);
    Optional<Curso> findById(Long id);
    Curso update(Curso curso);
    List<Curso> findAll();
    Page<Curso> findAll(Pageable pageable);
}
