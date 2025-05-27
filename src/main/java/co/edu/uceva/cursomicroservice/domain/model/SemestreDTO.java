package co.edu.uceva.cursomicroservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SemestreDTO {
    private Long id;
    private Long idPrograma;
    private Byte numeroSemestre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
}
