package cursos.br.com.example.service.impl;

import cursos.br.com.example.dto.CursoDTO;
import cursos.br.com.example.entity.Curso;
import cursos.br.com.example.mapper.CursoMapper;
import cursos.br.com.example.repository.CursoRepository;
import cursos.br.com.example.service.CursoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private CursoRepository repository;
    private CursoMapper mapper;

    public CursoServiceImpl(CursoRepository repository, CursoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CursoDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::toCursoDTO)
                .toList();
    }

    @Override
    public CursoDTO buscarPor(int id) {
        Curso curso = checkId(id);
        return mapper.toCursoDTO(curso);
    }

    @Override
    public CursoDTO cadastrar(CursoDTO cursoDTO) {
        Curso curso = mapper.toCurso(cursoDTO);
        Curso cursoSalvo = repository.save(curso);
        return mapper.toCursoDTO(cursoSalvo);
    }

    @Override
    public CursoDTO atualizar(int id, CursoDTO cursoDTO) {
        Curso curso = checkId(id);
        curso.setNome(cursoDTO.nome());
        curso.setCargaHoraria(cursoDTO.cargaHoraria());
        curso.setDescricao(cursoDTO.descricao());
        curso.setVagas(cursoDTO.vagas());
        Curso cursoAtualizado = repository.save(curso);
        return mapper.toCursoDTO(cursoAtualizado);
    }

    @Override
    public void excluir(int id) {
        Curso curso = checkId(id);
        repository.delete(curso);
    }

    private Curso checkId(int id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
    }
}
