package co.edu.uceva.cursomicroservice.delivery.rest;

import co.edu.uceva.cursomicroservice.domain.exception.*;
import co.edu.uceva.cursomicroservice.domain.model.Curso;
import co.edu.uceva.cursomicroservice.domain.model.UsuarioDTO;
import co.edu.uceva.cursomicroservice.domain.service.ICursoService;
import co.edu.uceva.cursomicroservice.domain.service.ISemestreClient;
import co.edu.uceva.cursomicroservice.domain.service.IUsuarioClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/curso-service")
public class CursoRestController {

    private final ICursoService cursoService;

    // Declaramos como final el servicio para mejorar la inmutabilidad
    private final ICursoService Cursomicroservice;
    private final IUsuarioClient usuarioService;
    private final ISemestreClient semestreService;

    private static final String MENSAJE = "mensaje";
    private static final String CURSO = "curso";
    private static final String CURSOS = "cursos";


    public CursoRestController(ICursoService cursoService, IUsuarioClient usuarioService, ISemestreClient semestreService) {
        this.cursoService = cursoService;
        this.usuarioService = usuarioService;
        this.semestreService = semestreService;
    }

    @GetMapping("/cursos")
    public ResponseEntity<Map<String, Object>> getCursos() {
        List<Curso> cursos = cursoService.findAll();
        if (cursos.isEmpty()) {
            throw new NoHayCursosException();
        }
        Map<String, Object> response = new HashMap<>();
        response.put(CURSOS, cursos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/curso/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Curso> cursos = cursoService.findAll(pageable);
        if (cursos.isEmpty()) {
            throw new PaginaSinCursosException(page);
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Curso curso, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Map<String, Object> response = new HashMap<>();
        Curso nuevoCurso = cursoService.save(curso);
        response.put(MENSAJE, "El curso ha sido creado con éxito!");
        response.put(CURSO, nuevoCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/cursos")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Curso curso) {
        cursoService.findById(curso.getId())
                .orElseThrow(() -> new CursoNoEncontradoException(curso.getId()));
        cursoService.delete(curso);
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "El curso ha sido eliminado con éxito!");
        response.put(CURSO, null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/cursos")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Curso curso, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        cursoService.findById(curso.getId())
                .orElseThrow(() -> new CursoNoEncontradoException(curso.getId()));
        Map<String, Object> response = new HashMap<>();
        Curso cursoActualizado = cursoService.update(curso);
        response.put(MENSAJE, "El curso ha sido actualizado con éxito!");
        response.put(CURSO, cursoActualizado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable long id) {

        Curso curso = cursoService.findById(id)
                .orElseThrow(() -> new CursoNoEncontradoException(id));
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "El curso ha sido encontrado con éxito!");
        response.put(CURSO, curso);
        return ResponseEntity.ok(response);
    }
}