package cursos.br.com.example.mapper;

import cursos.br.com.example.dto.CursoDTO;
import cursos.br.com.example.entity.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDTO toCursoDTO(Curso curso);
    Curso toCurso(CursoDTO cursoDto);
}
