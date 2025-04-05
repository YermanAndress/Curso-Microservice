package com.cursomicroservice.cursomicroservice.domain.repository;

import com.cursomicroservice.cursomicroservice.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
