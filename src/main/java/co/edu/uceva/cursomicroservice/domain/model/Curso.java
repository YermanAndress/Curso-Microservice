package co.edu.uceva.cursomicroservice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El Curso debe tener nombre")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "El Curso Debe Tener Descripcion")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "El Curso Debe Estar Vinculado A Un Docente")
    @Column(nullable = false)
    private long idDocente;

    @NotNull(message = "El Curso Debe Estar Vinculado A Un Semestre")
    @Column(nullable = false)
    private long idSemestre;

    @NotBlank(message = "El Curso Debe Tener Una Modalidad")
    @Column(nullable = false)
    private String modalidad;

    @NotNull(message = "Debe Especificar El Numero De Creditos")
    @Column(nullable = false)
    private Byte numeroCreditos;

    @NotNull(message = "Debe Especificar La Duracion Del Curso")
    @Column(nullable = false)
    private Integer duracion;

    @NotNull(message = "Debe Especificar El Numero De Cupos Disponibles")
    @Column(nullable = false)
    private Byte cuposDisponibles;

    @NotNull(message = "Debe Ingresar La Fecha De Creacion Del Curso")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaCreacion;

    @NotNull(message = "Debe Especificar El Horario Del Curso")
    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private boolean activo;

}
