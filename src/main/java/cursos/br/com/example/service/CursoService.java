package cursos.br.com.example.service;

import cursos.br.com.example.dto.CursoDTO;

import java.util.List;


public interface CursoService {
    List<CursoDTO> buscarTodos();
    CursoDTO buscarPor(int id);
    CursoDTO cadastrar(CursoDTO cursoDTO);
    CursoDTO atualizar(int id, CursoDTO cursoDTO);
    void excluir(int id);
}
