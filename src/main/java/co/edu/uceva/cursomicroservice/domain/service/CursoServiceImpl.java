package co.edu.uceva.cursomicroservice.domain.service;

import co.edu.uceva.cursomicroservice.domain.model.Curso;
import co.edu.uceva.cursomicroservice.domain.repository.ICursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements ICursoService{

    ICursoRepository cursoRepository;

    public CursoServiceImpl(ICursoRepository cursoRepository) {this.cursoRepository = cursoRepository;}

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    @Transactional
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

}
